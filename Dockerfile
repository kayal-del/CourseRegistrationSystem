# Build stage using Maven and Java 21
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY backend/pom.xml .
COPY backend/src ./src

# Package application jar skipping unit tests
RUN mvn clean package -DskipTests

# Runtime stage using lightweight JRE 21
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose default port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
