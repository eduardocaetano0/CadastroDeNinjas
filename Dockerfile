FROM openjdk:17-jdk-slim

LABEL maintainer="eduardocaetano110@gmail.com"
WORKDIR /app

COPY target/CadastroDeNinjas-0.0.1-SNAPSHOT.jar /app/cadastro-ninjas-docker.jar

ENTRYPOINT ["java", "-jar", "cadastro-ninjas-docker.jar"]