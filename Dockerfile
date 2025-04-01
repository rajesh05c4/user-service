# Use a lightweight base image with Java 17
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on (typically 8080)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]