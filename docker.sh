#!/bin/bash

cd config-server
mvn clean install -DskipTests=True
docker build -t sebacassone/config-server .
docker push sebacassone/config-server

cd ../eureka-server
mvn clean install -DskipTests=True
docker build -t sebacassone/eureka-server .
docker push sebacassone/eureka-server

cd ../gateway-server
mvn clean install -DskipTests=True
docker build -t sebacassone/gateway-server .
docker push sebacassone/gateway-server

cd ../prueba-server
mvn clean install -DskipTests=True
docker build -t sebacassone/prueba-server .
docker push sebacassone/prueba-server

cd ../address-server
gradlew clean build
docker build -t sebacassone/address-server .
docker push sebacassone/address-server

cd ../debts-server
gradlew clean build
docker build -t sebacassone/debts-server .
docker push sebacassone/debts-server

cd ../documents-server
gradlew clean build
docker build -t sebacassone/documents-server .
docker push sebacassone/documents-server

cd ../loans-server
gradlew clean build
docker build -t sebacassone/loans-server .
docker push sebacassone/loans-server

cd ../users-server
gradlew clean build
docker build -t sebacassone/users-server .
docker push sebacassone/users-server
