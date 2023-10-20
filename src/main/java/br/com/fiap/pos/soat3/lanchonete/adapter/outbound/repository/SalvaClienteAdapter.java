package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.SalvaClienteAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SalvaClienteAdapter implements SalvaClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    public SalvaClienteAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public Cliente salvaCliente(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setCPF(cliente.getCPF());
        cliente.setId(clienteRepository.save(clienteEntity).getId());
        return cliente;
    }
}
