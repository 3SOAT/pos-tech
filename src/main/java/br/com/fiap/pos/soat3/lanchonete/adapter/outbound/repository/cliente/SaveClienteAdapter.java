package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente.mapper.ClienteMapper;
import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityExistsException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente.SalvaClienteAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveClienteAdapter implements SalvaClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    public SaveClienteAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    @Transactional
    public Cliente saveCliente(Cliente cliente) {

        if (clienteRepository.findByCpf(cliente.getCPF()).isEmpty()) {
            cliente.setId(clienteRepository.save(clienteMapper.getEntityFromDomain(cliente)).getId());
        } else {
            throw new EntityExistsException("Cliente", String.valueOf(cliente.getId()));
        }
        return cliente;
    }
}
