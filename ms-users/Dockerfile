FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

RUN mvn clean package -DskipTests -pl bootloader spring-boot:repackage

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/bootloader/target/bootloader-0.0.1-SNAPSHOT.jar app.jar

ENV SPRING_PROFILES_ACTIVE=local
ENV SERVER_SERVLET_CONTEXT_PATH=/api

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]