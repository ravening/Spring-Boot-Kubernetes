#!/usr/bin/env bash

# Create service account
kubectl apply -f configmap/kubernetes/serviceaccount.yaml

# Create role
kubectl apply -f configmap/kubernetes/role.yaml

# Bind service account to role
kubectl apply -f configmap/kubernetes/rolebinding.yaml

# Create cluster-admin rules for service account
kubectl create clusterrolebinding configmaps-clusteradmin --clusterrole=cluster-admin --serviceaccount=k8:configmaps

# Deploy the server
kubectl apply -f configserver/kubernetes/deploy.yaml

# Create configmap for client
kubectl apply -f configmap/kubernetes/config.yaml

# Deploy the client
kubectl apply -f configmap/kubernetes/deploy.yaml