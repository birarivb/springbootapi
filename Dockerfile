
FROM eclipse-temurin:21-alpine

WORKDIR /usr/app

COPY target/springbootapi.jar /usr/app/

ENTRYPOINT ["java", "-jar", "springbootapi.jar"]
