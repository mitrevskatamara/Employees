FROM amazoncorretto:11.0.14
WORKDIR /app

COPY Employees-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080
