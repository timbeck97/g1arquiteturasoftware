FROM openjdk:17
WORKDIR /app
COPY target/apigateway-0.0.1-SNAPSHOT.jar /app/apigateway.jar
ENTRYPOINT ["java", "-jar", "apigateway.jar"]