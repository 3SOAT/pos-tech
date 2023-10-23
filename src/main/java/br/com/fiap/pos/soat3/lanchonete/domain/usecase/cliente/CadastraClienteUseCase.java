package br.com.fiap.pos.soat3.lanchonete.domain.usecase.cliente;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.cliente.CadastraClienteUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente.SalvaClienteAdapterPort;

public class CadastraClienteUseCase implements CadastraClienteUseCasePort {

    private final SalvaClienteAdapterPort salvaClienteAdapterPort;

    public CadastraClienteUseCase(SalvaClienteAdapterPort salvaClienteAdapterPort) {
        this.salvaClienteAdapterPort = salvaClienteAdapterPort;
    }

    @Override
    public Cliente execute(Cliente cliente) {
       return salvaClienteAdapterPort.saveCliente(cliente);
    }
}
