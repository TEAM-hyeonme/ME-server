FROM openjdk:11-jdk

WORKDIR /usr/src/app

ARG JAR_FILE=me-api/build/libs/me-api-0.0.1-SNAPSHOT.jar

COPY $JAR_FILE app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
