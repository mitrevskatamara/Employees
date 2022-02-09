FROM amazoncorretto:11.0.14
COPY . .
ENTRYPOINT ["java", "-jar", "*.jar"]
EXPOSE 8080
