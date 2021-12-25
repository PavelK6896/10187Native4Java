
FROM gradle:7.3.2-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17-slim

ENV PR-1=PR-
ENV PR-2=_Pr2
ENV PR3=pr3

EXPOSE 8080

RUN mkdir /app
WORKDIR /app

COPY ./src/main/resources/add.yaml /app/config/add.yaml
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT [ "java","-Dspring.config.additional-location=./config/add.yaml", \
 "-Djava.security.two=urandom-two","-Djava.t-test.pr=pr-two", "-jar","spring-boot-application.jar"]

