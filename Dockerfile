FROM adoptopenjdk/openjdk11:latest AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle.kts settings.gradle.kts gradlew $APP_HOME/
COPY gradle $APP_HOME/gradle/
COPY . .
RUN chmod +x $APP_HOME/gradlew
RUN ./gradlew -x test build

FROM adoptopenjdk/openjdk11:latest
ENV ARTIFACT_NAME=me-api.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8080
ENTRYPOINT java -jar $ARTIFACT_NAME