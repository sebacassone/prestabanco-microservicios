#!/bin/bash

cd deployments/
kubectl delete services --all
kubectl delete pods --all
kubectl delete deployments --all

kubectl apply -f config-server-deployment.yaml
kubectl apply -f config-secrets.yaml
kubectl apply -f eureka-server-deployment.yaml
kubectl apply -f gateway-server-deployment.yaml
kubectl apply -f jenkins-deployment.yaml
kubectl apply -f prueba-server-deployment.yaml
