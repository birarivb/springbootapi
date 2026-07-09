FROM eclipse-temurin:21-alpine

WORKDIR /usr/app

COPY target/springbootapi.jar app.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "app.jar"]
