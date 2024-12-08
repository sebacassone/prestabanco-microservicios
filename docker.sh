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

