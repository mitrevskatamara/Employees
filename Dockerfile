FROM maven:3-amazoncorretto-11
RUN mvn -B -f pom.xml clean package -DskipTests
FROM amazoncorretto:11.0.14
COPY . .
ENTRYPOINT ["java", "-jar", "*.jar"]
