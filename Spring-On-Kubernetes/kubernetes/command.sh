#!/usr/bin/env bash
kubectl create clusterrolebinding default --clusterrole=cluster-admin --serviceaccount=default:default


# kustomize build https://github.com/dsyer/docker-services/layers/samples/petclinic?ref=HEAD | kubectl apply -f -
# kubectl port-forward service/petclinic-app --address 0.0.0.0 8080:80
