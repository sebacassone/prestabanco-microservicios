FROM openjdk:17
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} documents-server.jar
ENTRYPOINT ["java","-jar","/documents-server.jar"]