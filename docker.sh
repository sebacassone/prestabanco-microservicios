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

cd ../addresses-server
./gradlew clean build -x test
docker build -t sebacassone/addresses-server .
docker push sebacassone/addresses-server

cd ../debts-server
./gradlew clean build -x test
docker build -t sebacassone/debts-server .
docker push sebacassone/debts-server

cd ../documents-server
./gradlew clean build -x test
docker build -t sebacassone/documents-server .
docker push sebacassone/documents-server

cd ../loans-server
./gradlew clean build -x test
docker build -t sebacassone/loans-server .
docker push sebacassone/loans-server

cd ../users-server
./gradlew clean build -x test
docker build -t sebacassone/users-server .
docker push sebacassone/users-server

cd ../../Monolítica/frontend/
docker build --build-arg VITE_PAYROLL_BACKEND_SERVER=192.168.49.2:30000 -t sebacassone/frontend-server .
docker push sebacassone/frontend-server
