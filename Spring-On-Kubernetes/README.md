# Spring Boot on Kubernetes

https://hackmd.io/@ryanjbaxter/spring-on-k8s-workshop

curl https://start.spring.io/starter.tgz -d artifactId=k8s-demo-app -d name=k8s-demo-app -d packageName=com.example.demo -d dependencies=web,actuator -d javaVersion=11 | tar -xzf -

 ./mvnw spring-boot:build-image

 ./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=demo

 kubectl create configmap log-level --from-literal=LOGGING_LEVEL_ORG_SPRINGFRAMEWORK=DEBUG

skaffold dev --port-forward

or

skaffold dev -p qa --port-forward

kubectl --context minikube port-forward --pod-running-timeout 1s service/k8s-demo-app 9001:8080 --address 0.0.0.0


kustomize build ./kustomize/base

kustomize build ./kustomize/qa

kustomize build https://github.com/dsyer/docker-services/layers/samples/petclinic?ref=HEAD | kubectl apply -f -
kubectl port-forward service/petclinic-app --address 0.0.0.0 8080:80
