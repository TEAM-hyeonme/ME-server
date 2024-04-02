FROM openjdk:11-jdk

WORKDIR /usr/src/app

ARG JAR_DR=me-api/build/libs
ARG JAR_FILE=me-api-0.0.1-SNAPSHOT.jar

COPY $JAR_DR/$JAR_FILE $JAR_DR/$JAR_FILE

EXPOSE 8080

CMD ["java","-jar","$JAR_DR/$JAR_FILE"]