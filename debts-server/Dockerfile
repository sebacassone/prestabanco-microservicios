FROM openjdk:17
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} debts-server.jar
ENTRYPOINT ["java","-jar","/debts-server.jar"]