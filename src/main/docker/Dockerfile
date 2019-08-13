FROM openjdk:8-jdk-alpine
ADD *.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app.jar"]
