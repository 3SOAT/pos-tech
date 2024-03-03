# Tech Challenge - FIAP
Projeto da Pós Tech da FIAP em Software Architecture

## Autoras

✨ [@leonara](https://github.com/leonara) | [@alinedonatoc](https://github.com/alinedonatoc) | [@assouza19](https://github.com/assouza19) ✨

## Descrição do Projeto
Uma lanchonete de bairro está expandindo seus negócios e começando a ter dificuldades em controlar o fluxo de seus pedidos.
Pensando nisso, a lanchonete resolveu investir em um sistema de autoatendimento onde o cliente poderá selecionar e fazer pedidos sem precisar interagir
com um atendente, além de poder acompanhar o status do seu pedido e também realizar o pagamento do mesmo online.
Esse tech challenge se limita à solução de backend, sendo assim, não há interfaces/aplicações visuais, somente APIs e arquitetura de escala.


## Documentação

- [DDD](https://miro.com/app/board/uXjVNdf5-GE=/?share_link_id=675194698681)
- [Swagger](https://github.com/leonara/pos-tech/blob/main/swagger/openapi.json)
- [Postman](https://github.com/leonara/pos-tech?tab=readme-ov-file#:~:text=test%20with%20postman-,Postman%20Collection,-To%20run%20locally)


## Tecnologias utilizadas

**Base de dados:** PostgreSql

**Back-end:** Java, Spring

**Arquitetura:** Clean Architecture

**Ferramentas:** Docker


## Arquitetura

### Solução
![Arquitetura](https://iili.io/JcMEdDN.md.png)

### K8s
![Arquitetura](https://iili.io/JcM2chX.md.png)

### Diagrama de Entidades
![Diagrama](https://iili.io/JcaG9un.md.jpg)

## Demonstração

[Youtube](https://youtu.be/snBFICM0EXU) | [Apresentação PPT](https://docs.google.com/presentation/d/1hZupMjyPEl4gAjgGiPyhvc325YhSDVaryYZD6WQMjn0/edit?usp=sharing)

### Demo autoscaling - HPA

Rodamos o postman com 1000 requisições no endpoint de criação de produto.

https://github.com/leonara/pos-tech/assets/147456852/d34d7720-77da-498d-93d9-397403ec9c57


## Funcionalidades

- Cadastrar e buscar cliente
- Cadastrar e atualizar produto
- Listar produtos
- Buscar produto por categoria
- Deletar produto
- Consultar status do Pedido
- Listar pedidos
- Atualizar status do pedidos
- Realizar pagamento
- Listar categorias


## Rodando localmente

- Instale o Docker em sua máquina

- Clone o projeto

```bash
  git clone git@github.com:leonara/pos-tech.git
```

- Crie o volume no docker

```bash
  docker volume create data
```

- Inicie o serviço

```bash
  docker-compose -f local-autoservico.yaml up -d
```

### Rodando localmente com k8s

```bash
  kubectl apply -f k8s/db/pvs.yaml
  kubectl apply -f k8s/db/deployment.yaml
  
  kubectl exec -it <postgres_pod_name> -- bash
  psql -U local
  CREATE DATABASE autoservico;
    
    
  kubectl apply -f k8s/mock/deployment-mock.yaml
  kubectl apply -f k8s/deployment.yaml
  kubectl port-forward svc/demo 8080:8080
```
