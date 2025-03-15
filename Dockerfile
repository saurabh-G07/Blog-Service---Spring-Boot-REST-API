FROM openjdk:17
WORKDIR /app
COPY target/blog-service.jar blog-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "blog-service.jar"]