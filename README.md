# pos-tech
Projeto da Pós Tech da FIAP em Software Architecture


## DDD process on Miro
[Miro](https://miro.com/app/board/uXjVNdf5-GE=/?share_link_id=675194698681)

## To see API's documentation
[Swagger](swagger/openapi.json)

## To test with postman
[Postman Collection](postman/pos-tech.postman_collection.json)

## To run locally use:
```docker volume create data```

```docker-compose -f autoservico.yaml up -d```

## To create deployment
Refs
https://spring.io/guides/gs/spring-boot-kubernetes/
https://medium.com/digital-software-architecture/spring-boot-kubernetes-scalability-with-horizontal-pod-autoscaler-hpa-faced00b52bf
```
-- criar imagem quando não disponivel no docker hub
docker tag api-img:latest enilapb/api-img:v1 --lembrar de versionar
docker push enilapb/api-img:v1

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
kubectl exec -it <pod_name> -c container -- ash

-- ver metricas 
kubectl get pods -n kube-system

-- como criar o hpa 
echo --- >> k8s/deployment.yaml
kubectl autoscale deployment demo --dry-run=client -o yaml --cpu-percent=50 --min=1 --max=10 >> k8s/deployment.yaml

```
