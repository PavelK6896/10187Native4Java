- buildDependents
- java -jar 10187Native4Java-1.0.jar
- native-image -jar 10187Native4Java-1.0.jar

- java -Dspring.config.additional-location=../../src/main/resources/add.yaml -jar 10187Native4Java-1.0.jar

<details>
  <summary>one Dockerfile</summary>

- docker build -t one-n-1 -f one.Dockerfile .
- docker run --name n-n-1 -p 8080:8080 -d one-n-1

</details>
<details>
  <summary>two Dockerfile</summary>

- docker build -t two-n-2 -f two.Dockerfile .
- docker run --name n-n-2 -p 8081:8080 -d two-n-2

</details>
<details>
  <summary>three Dockerfile</summary>

- docker build -t three-n-3 -f three.Dockerfile .
- docker run -e JAVA_OPTS='-Dserver.port=8080' --name three-n-3 -p 8080:8080 -d three-n-3

- docker tag three-n-3 pavelk6896/10187native4-3:latest
- docker push pavelk6896/10187native4-3:latest

  <details>
    <summary>one k8s</summary>

    - kubectl apply -f ./one.yaml
    - kubectl get all
    - kubectl delete -f ./one.yaml
  </details>
  <details>
    <summary>two k8s</summary>

    - kubectl apply -f ./two-k8s/components-metrics-server.yaml
    - kubectl apply -f ./two-k8s/two.yaml
    - kubectl get all
    - kubectl delete -f ./two-k8s/two.yaml
  </details>

</details>