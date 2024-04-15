FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/apigateway-0.0.1-SNAPSHOT.jar  /app/apigateway.jar

CMD ["java", "-jar", "apigateway.jar"]