package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente;

import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente.BuscaClientePorCPFAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class BuscaClientePorCPFAdapter implements BuscaClientePorCPFAdapterPort {

    private final ClienteRepository clienteRepository;

    public BuscClientePorCPFAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente buscaCliente(String cpf) {
        try {
            var clienteEntity = clienteRepository.findByCpf(cpf);
            return Cliente.fromEntity(clienteEntity);
        } catch (Exception exception) {
            throw new EntityNotFoundException("Cliente", String.valueOf(cpf));
        }
    }
}
