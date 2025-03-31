# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file from the target directory
COPY target/*.jar app.jar

# Run the JAR file with Java
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Expose port 8080 (default for Spring Boot apps)
EXPOSE 8080

