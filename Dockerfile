
FROM eclipse-temurin:21-alpine

WORKDIR /usr/app

COPY target/springbootapp.jar /usr/app/

ENTRYPOINT ["java", "-jar", "springbootapp.jar"]
