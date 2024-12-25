# Step 1: Use OpenJDK as the base image
FROM openjdk:17-alpine

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the JAR file into the container
# Replace 'your-app.jar' with the actual name of your Spring Boot JAR file
COPY target/EmployeeManagment-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port the application runs on
# Replace 8080 with the port configured in your application.properties
EXPOSE 8080

# Step 5: Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
