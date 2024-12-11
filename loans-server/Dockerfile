FROM openjdk:17
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} loans-server.jar
ENTRYPOINT ["java","-jar","/loans-server.jar"]