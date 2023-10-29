package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente.mapper.ClienteMapper;
import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente.BuscaClientePorCPFAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscaClientePorCPFAdapter implements BuscaClientePorCPFAdapterPort {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    public BuscaClientePorCPFAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Cliente buscaCliente(String cpf) {
        var clienteEntity = clienteRepository.findByCpf(cpf);
        if (clienteRepository.findByCpf(cpf).isPresent()) {
            return clienteMapper.fromEntity(clienteEntity.get());
        } else {
            throw new EntityNotFoundException("Cliente", cpf);
        }
    }
}
