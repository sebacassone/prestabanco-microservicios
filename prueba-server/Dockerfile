FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} prueba-service.jar
ENTRYPOINT ["java","-jar","/prueba-service.jar"]