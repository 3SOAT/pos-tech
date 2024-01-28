package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.cliente;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.cliente.ClienteEntity;

public class ClienteEntityMapper {

    ClienteEntity toEntity(Cliente clienteDomainObj) {

        return new ClienteEntity(clienteDomainObj.getNome(),
                clienteDomainObj.getEmail(),
                clienteDomainObj.getCPF());
    }

    Cliente toDomainObj(ClienteEntity clienteEntity) {
        return new Cliente(clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getEmail(),
                clienteEntity.getCpf());
    }
}
