# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY targetJar/spring-practise-dec.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
