package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.SalvaClienteAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveClienteAdapter implements SalvaClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    public SaveClienteAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public Cliente saveCliente(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setCpf(cliente.getCPF());
        cliente.setId(clienteRepository.save(clienteEntity).getId());
        return cliente;
    }
}
