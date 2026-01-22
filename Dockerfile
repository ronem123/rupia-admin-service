FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/rupia-admin-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","app.jar"]