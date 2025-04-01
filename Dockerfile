# Stage 1: Build the Spring Boot application
FROM maven:3.8.5-openjdk-17 AS builder # Or gradle:7-jdk17
WORKDIR /app
COPY pom.xml . # Or build.gradle and settings.gradle
COPY src ./src
RUN mvn clean package -DskipTests # Or gradle build -x test

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]