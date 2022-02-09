FROM maven:3-amazoncorretto-11
RUN mkdir -p /app
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn -B -f pom.xml clean package -DskipTests
FROM amazoncorretto:11.0.14
EXPOSE 8080
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
