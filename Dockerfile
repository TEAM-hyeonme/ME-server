FROM openjdk:11-ea-jdk-slim
VOLUME /tmp
COPY build/libs/me-0.0.1-SNAPSHOT.jar me.jar
ENTRYPOINT ["java","-jar","me.jar"]