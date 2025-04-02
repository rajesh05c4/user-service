FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files
RUN ls -la /app

COPY pom.xml .
COPY src/ src/

# Build the application
RUN mvn clean package -DskipTests

# Use a minimal JDK runtime for the final image
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR file
COPY --from=build /app/target/*.jar app.jar

# Expose the port Render will use
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]