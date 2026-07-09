
FROM eclipse-temurin:17-jdk

WORKDIR /usr/app

COPY target/springbootapp.jar /usr/app/

ENTRYPOINT ["java", "-jar", "springbootapp.jar"]
