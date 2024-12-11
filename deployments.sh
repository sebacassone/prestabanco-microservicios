#!/bin/bash

cd deployments/
kubectl delete services --all
kubectl delete pods --all
kubectl delete deployments --all

# Microservices Patterns
kubectl apply -f config-deployment.yaml
kubectl apply -f config-secrets.yaml
kubectl apply -f eureka-deployment.yaml
kubectl apply -f gateway-deployment.yaml
kubectl apply -f jenkins-deployment.yaml
kubectl apply -f prueba-deployment.yaml

# Database
kubectl apply -f postgres-secrets.yaml
kubectl apply -f postgres-deployment.yaml

# Microservices
kubectl apply -f addresses-deployment.yaml
kubectl apply -f debts-deployment.yaml
kubectl apply -f documents-deployment.yaml
kubectl apply -f loans-deployment.yaml
kubectl apply -f users-deployment.yaml

# Frontend
kubectl apply -f frontend-deployment.yaml
