FROM openjdk:17
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} addresses-server.jar
ENTRYPOINT ["java","-jar","/addresses-server.jar"]