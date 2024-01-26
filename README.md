# Pós Tech - FIAP
Projeto da Pós Tech da FIAP em Software Architecture

## Autoras

✨ [@leonara](https://github.com/leonara) | [@alinedonatoc](https://github.com/alinedonatoc) | [@assouza19](https://github.com/assouza19) ✨


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

![Arquitetura](https://iili.io/JcIV1e4.jpg)
## Demonstração

O VÍDEO DO YOUTUBE SERÁ INSERIDO AQUI


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
  kubectl apply -f k8s/deployment.yaml
```
