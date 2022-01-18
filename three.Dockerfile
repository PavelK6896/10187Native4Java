
FROM ghcr.io/graalvm/graalvm-ce:java17-21.3.0-b1 AS builder
RUN microdnf install curl unzip zip

RUN curl -s https://get.sdkman.io | bash; \
    source "$HOME/.sdkman/bin/sdkman-init.sh"; \
    sdk version;  \
    sdk install gradle; \
    gu install native-image;
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && gradle -v
RUN native-image --version


FROM builder AS gradle
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && gradle nativeCompile


FROM oraclelinux:8-slim
LABEL com.example.version="0.0.1"
ENV NAME_APP=10187Native4Java

ENV AST_NEW_TWO=333333333
ENV PARAM_L2="44444444, 22, 1"
ENV PR_TWO=7
ENV PR_L2=555

COPY --from=gradle "/home/gradle/src/build/native/nativeCompile/$NAME_APP" spring-boot-native
CMD [ "sh", "-c", "./spring-boot-native -Djava.t-test.pr=pr-three -Dserver.port=8083" ]

