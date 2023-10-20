package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository;

import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.BuscaClientePorCPFAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class BuscaClientePorCPFAdapter implements BuscaClientePorCPFAdapterPort {

    private final ClienteRepository clienteRepository;

    public BuscaClientePorCPFAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente buscaCliente(String cpf) {
        try {
            var clienteEntity = clienteRepository.buscaPorCpf(cpf);
            return Cliente.fromEntity(clienteEntity);
        } catch (Exception exception) {
            throw new EntityNotFoundException("Cliente", 0L);
        }
    }
}
