# Spring Boot + Docker + Kubernetes Demo

A small Spring Boot application for a college FSAD/DevOps lab demonstration.

## Prerequisites

Install Java 21, Maven, Docker, and a Kubernetes cluster with `kubectl` configured.

## Build the Spring Boot application

From the `spring-k8s-demo` directory, run:

```bash
./mvnw clean package
```

The executable JAR is created in `target/`.

## Run with Docker

Build the Docker image:

```bash
docker build -t defaultbootnew-demo:1.0 .
```

Run the container:

```bash
docker run -p 8080:8080 defaultbootnew-demo:1.0
```

The application is then available at:

- `http://localhost:8080/`
- `http://localhost:8080/hello`
- `http://localhost:8080/employee`

## Deploy to Kubernetes with Docker Desktop

Select and verify the Docker Desktop Kubernetes context:

```bash
kubectl config use-context docker-desktop
kubectl config current-context
```

Create the namespace, deploy three application replicas, and create the
NodePort Service in the same `springboot` namespace:

```bash
kubectl create namespace springboot
kubectl apply -f k8s/deployment.yaml -n springboot
kubectl apply -f k8s/service.yaml -n springboot
```

Check the Deployment:

```bash
kubectl get deployments -n springboot
```

Check the Pods:

```bash
kubectl get pods -n springboot
```

View logs for a Pod by replacing `<pod-name>` with a real Pod name:

```bash
kubectl logs <pod-name> -n springboot
```

Check the Service, cluster nodes, and Service endpoints:

```bash
kubectl get service -n springboot
kubectl get nodes -o wide
kubectl get endpoints -n springboot
```

Show Deployment details:

```bash
kubectl describe deployment defaultboot-k8s-demo -n springboot
```

Port-forward the Service for a local test:

```bash
kubectl port-forward service/springboot-service 8080:8080 -n springboot
```

Then open:

- `http://localhost:8080`
- `http://localhost:8080/hello`
- `http://localhost:8080/employee`

To delete a Pod, replace `<pod-name>` with a real Pod name:

```bash
kubectl delete pod <pod-name> -n springboot
```

Because the Deployment has `replicas: 3`, Kubernetes automatically creates a
replacement Pod when one of the Pods is deleted.
