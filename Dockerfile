FROM openjdk:11-jdk-slim
WORKDIR /usr/app
ARG JAR_FILE=me-api/build/libs/*.jar
COPY ${JAR_FILE} me-api-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "me-api-0.0.1-SNAPSHOT.jar"]