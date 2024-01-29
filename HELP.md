# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## To create deployment
Refs
https://spring.io/guides/gs/spring-boot-kubernetes/
https://medium.com/digital-software-architecture/spring-boot-kubernetes-scalability-with-horizontal-pod-autoscaler-hpa-faced00b52bf
```
-- criar imagem quando não disponivel no docker hub
docker-compose -f autoservico-db.yaml up -d --build
docker-compose -f autoservico-db.yaml down
docker tag api-img:latest enilapb/api-img:v1 --lembrar de versionar
docker push enilapb/api-img:v1

docker tag mockoon-changed:latest enilapb/mockoon-changed:v1
docker push enilapb/mockoon-changed:v1

-- para criar k8s/deployment.yaml
kubectl create deployment demo --image=enilapb/api-img:v1 --dry-run=client -o=yaml > k8s/deployment.yaml
echo --- >> k8s/deployment.yaml

-- para adicionar o service ao k8s/deployment.yaml
kubectl create service clusterip demo --tcp=8080:8080 --dry-run=client -o=yaml >> k8s/deployment.yaml

kubectl apply -f k8s/deployment.yaml

-- criando tunel para acesso ao service
kubectl port-forward svc/demo 8080:8080

-- testando
curl localhost:8080/actuator/health
--> Resposta = {"status":"UP"}

-- instalando as metrics do k8s
kubectl apply -f k8s/metrics.yaml

-- para acesso ao pod
kubectl exec -it <pod_name> -c container -- bash

-- ver metricas 
kubectl get pods -n kube-system

-- como criar o hpa 
echo --- >> k8s/deployment.yaml
kubectl autoscale deployment demo --dry-run=client -o yaml --cpu-percent=50 --min=1 --max=10 >> k8s/deployment.yaml


--cleaning 
kubectl delete deployment.apps/demo
kubectl delete deployment.apps/postgres
kubectl delete deployment.apps/mockoon

docker image rm enilapb/api-img:v1
docker image rm api-img
```
