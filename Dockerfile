FROM openjdk:11-jdk

WORKDIR /usr/src/app

COPY me-api/build/libs/me-api-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "me-api-0.0.1-SNAPSHOT.jar"]