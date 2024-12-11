FROM openjdk:17
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} users-server.jar
ENTRYPOINT ["java","-jar","/users-server.jar"]