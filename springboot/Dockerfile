# First stage: Build the application
FROM maven:3.8.6-openjdk-11 AS builder

# Set the working directory
WORKDIR /build

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package

# Second stage: Run the application
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the built application from the first stage
COPY --from=builder /build/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
COPY opentelemetry-javaagent-all.jar /app/opentelemetry-javaagent-all.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent-all.jar", "-Dotel.exporter.otlp.endpoint=http://otelcol:4317", "-jar", "/app/demo.jar"]
