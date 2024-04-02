FROM openjdk:11-jdk

WORKDIR /usr/src/app

COPY me-api/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
