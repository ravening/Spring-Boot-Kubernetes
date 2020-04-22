# Spring Cloud Kubernetes Configmaps and discovery client example

A sample spring cloud Java application to demonstrate the usage of\
configmaps and service discovery functionalities provided by kubernetes\
and how can they be easily used in spring cloud projects using the new\
`Spring Cloud Kubernetes` project.

## Description

This project has two components.

1 . Spring cloud kubernetes configmaps using Kubernetes Configmaps
2 . Spring cloud Kubernetes discovery client using Kubernetes service discovery

## Spring cloud kubernetes configmaps

Instead of using config server we can rely using kubernetes configmaps\
to load configs into java application.\

This is contained in the folder `configmap`

We store the configmaps in kubernets using config.yaml and then load those\
properties in application. Since active reload in enabled, whenever we\
change the configmaps values, they will be automatically reloaded.

Detailed steps will be described later


## Spring cloud kubernetes discovery client and server

Two microservices communicates with each other using service discovery.\
In spring cloud world we use Netflix Eureka server to do service discovery.\
In spring cloud kubernetes we use service discovery functionalities\
provided by kubernetes.

The server is in the folder `configserver` which exposes the endpoints on\
`/users`. Other microservice components can call this endpoint using\
service discovery like `http://users-service:8080/users` where\
`users-service` is the service of the `configserver`.\

The client is also located in the folder `configmap` which uses the\
annotation `EnableDiscoveryClient` to resolve the services and call\
the user service endpoint.\

Every 5 seconds it makes a request to server to get details and it also\
displays the configmap values.

# Running the application

Below steps explains what needs to be done to start the project

## Prerequisites

1 . Either kubernetes cluster or minikube should be installed.
2 . Java, maven and docker installed.
3 . It is assumed that the kubernetes namespace `k8` is created

## Building packages

Run the below command to build application and also to generate the\
docker image. Replace the dockerhub username with your username in\
`pom.xml` file

```
mvn clean package -DskipTests
```

Carefully look at the file `create_cluster_role.sh` which first creates\
service account, role, rolebinding and cluster role. After that it\
deploys the application.\

Also note the small changes done in `deploy.yaml` under each directories\
to include the service account and hostNetwork fields.

## Deploy the application in kubernetes

1 . Just run the below command to deploy both server and client
```
./create_cluster_role.sh
```

2 . Get all the services
```
kubectl get svc -n k8
```

3 . Note down the IP address of `users-service` service

4 . Once this is done ssh to client/configmaps pod to add a entry in `/etc/hosts`
```
<IP address of users-service> users-service
```

5 . If this is not added then client can't communicate to server


