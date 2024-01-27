package br.com.fiap.pos.soat3.lanchonete.application.usecases;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;

public class CriaClienteInteractor {
    private final ClienteGateway clienteGateway;

    public CriaClienteInteractor(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente criaCliente(Cliente cliente) {
        return clienteGateway.criaCliente(cliente);
    }
}
