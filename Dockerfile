FROM maven:3-amazoncorretto-11
RUN mkdir -p /app
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn -B -f pom.xml clean package -DskipTests
FROM amazoncorretto:11.0.14
COPY Employees-0.0.1-SNAPSHOT.jar Employees-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Employees-0.0.1-SNAPSHOT.jar"]
