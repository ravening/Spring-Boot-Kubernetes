# Spring boot Kubernetes development using Jkube

## Build the package
```
mvn clean package -DskipTests
```

## Build docker image
```
mvn k8s:build
```

## Creates kubernetes resources
```
mvn k8s:resource
```

## Push the image to docker hub
```
mvn k8s:push
```

## Deploy the application
```
mvn k8s:apply
```

## Get the logs
```
mvn k8s:log
```

## Debug the application
```
mvn k8s:debug
```
