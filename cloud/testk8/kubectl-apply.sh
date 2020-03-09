#!/bin/bash
# Files are ordered in proper order with needed wait for the dependent custom resource definitions to get initialized.
# Usage: bash kubectl-apply.sh

logSummary(){
    echo ""
    echo "#####################################################"
    echo "Please find the below useful endpoints,"
    echo "Gateway - http://admindashboard.jhipster.178.162.213.42.nip.io"
    echo "Gateway - http://customerdashboard.jhipster.178.162.213.42.nip.io"
    echo "Zipkin - http://zipkin.istio-system.178.162.213.42.nip.io"
    echo "Grafana - http://grafana.istio-system.178.162.213.42.nip.io"
    echo "Kiali - http://kiali.istio-system.178.162.213.42.nip.io"
    echo "#####################################################"
}

kubectl apply -f namespace.yml
kubectl apply -f rabbit.yml
kubectl label namespace jhipster istio-injection=enabled --overwrite=true
kubectl apply -f admindashboard/
kubectl apply -f customerdashboard/
kubectl apply -f virtualmachine/
kubectl apply -f privatecloud/
kubectl apply -f cloudstack/
kubectl apply -f customeraccount/
kubectl apply -f orders/

kubectl apply -f istio/
logSummary
