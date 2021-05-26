FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/quiz-email-verifier-second.jar
COPY ${JAR_FILE} quiz-email-verifier-second.jar
CMD ["java", "-jar", "quiz-email-verifier-second.jar", "--server.port=${PORT:8080}"]