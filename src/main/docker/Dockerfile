FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ADD web-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring-boot.run.arguments=\"--spring.profiles.active=localdev\"","-jar","/app.jar"]