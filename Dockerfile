FROM maven:3.9.9-eclipse-temurin-17 AS builder
 
WORKDIR /app
 
COPY pom.xml .
COPY /src ./src
 
RUN mvn clean package -DskipTests
 
FROM openjdk:17-jdk
 
WORKDIR /app
 
COPY --from=builder /app/target/*.jar /app/backend.jar
 
EXPOSE 8080
 
CMD ["java", "-jar", "backend.jar"]