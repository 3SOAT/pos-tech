package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente.mapper;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente.ClienteEntity;
import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente.ClienteRepository;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    private final ClienteRepository clienteRepository;

    public ClienteMapper(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteEntity getEntityFromDomain(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCPF());
        clienteEntity.setEmail(cliente.getEmail());
        return clienteEntity;
    }

    public Cliente fromEntity(ClienteEntity clienteEntity) {
        return new Cliente(clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getEmail(),
                clienteEntity.getCpf());
    }
}
