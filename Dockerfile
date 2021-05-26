# Build stage
FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean install -DskipTests

# Package stage
FROM openjdk:8-jdk-alpine
COPY --from=build /usr/src/app/target/quiz-email-verifier-second.jar /usr/app/quiz-email-verifier-second.jar
CMD ["java", "-jar", "/usr/app/quiz-email-verifier-second.jar", "--server.port=${PORT:8080}"]