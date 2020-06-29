# Tutorial 2

## Overview

This demonstrates how to deploy two applications and get them
talking to one another within Kubernetes.

## Dependencies

- Docker
- K8S

## Running

### Building the services

#### TimeService

- Build the image
```
cd timeservice
./mvnw spring-boot:build-image
 ```

#### Formatter Service

- Build the image
```
cd formatterservice
./mvnw spring-boot:build-image
 ```

You should now have two images as follows:

```
timeservice  1.0  ...
formatterservice  1.0 ...
```

### K8S Setup

- Run the following commands within you K8S cluster.
```
kubectl apply -f timeservice-deployment.yaml 
kubectl apply -f timeservice-service.yaml 
kubectl apply -f formatterservice-deployment.yaml 
kubectl apply -f formatterservice-service.yaml
```

### Accessing the endpoint

- In your browser access
```
http://localhost/formattedtime
```

## Notes

- Both apps run on port 8080.
- The time app responds to the path "/time". This is not
accessible outside of the cluster.
- The formatter app responds to the path "/formattedtime".
This is externally accessible.
- The formatter app requests the current time from the time
app. It accesses the time k8s service using a host:port/path specified
within environment variables in its deployment yaml. These match
the details in the time-service deployment.
- Environment variables get injected into the formatter app by
use of the application.yaml (inside the src/ directory of the formatter app.)
