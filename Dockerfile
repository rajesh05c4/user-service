# Use Maven with JDK 23 for the build
FROM maven:3.9.9-eclipse-temurin-23 AS build

# Set working directory
WORKDIR /app

# Copy Maven files first (for dependency caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY src ./src

# Build the application (skip tests for speed)
RUN mvn clean package -DskipTests

# Runtime image with OpenJDK 23
FROM eclipse-temurin:23-jdk

# Set working directory
WORKDIR /app

# Copy built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (change if needed)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
