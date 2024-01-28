package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.cliente;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.config.exception.EntityExistsException;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.cliente.ClienteEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.cliente.ClienteRepository;

import java.util.Optional;

public class ClienteRepositoryGateway implements ClienteGateway {

    private ClienteRepository clienteRepository;
    private ClienteEntityMapper clienteEntityMapper;

    public ClienteRepositoryGateway(ClienteRepository clienteRepository, ClienteEntityMapper clienteEntityMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public Cliente cadastraCliente(Cliente cliente) {
        Optional<ClienteEntity> buscaCliente = clienteRepository.findByCpf(cliente.getCPF());
        if (buscaCliente.isEmpty()) {
            ClienteEntity clienteEntity = clienteEntityMapper.toEntity(cliente);
            ClienteEntity savedEntity = clienteRepository.save(clienteEntity);
            return clienteEntityMapper.toDomainObj(savedEntity);
        } else {
            throw new EntityExistsException("Cliente", String.valueOf(cliente.getId()));
        }
    }

    @Override
    public Cliente buscaClientePorCPF(String cpf) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findByCpf(cpf);
        if (clienteEntity.isPresent()) {
            return clienteEntityMapper.toDomainObj(clienteEntity.get());
        } else {
            throw new EntityNotFoundException("Cliente", cpf);
        }
    }
}
