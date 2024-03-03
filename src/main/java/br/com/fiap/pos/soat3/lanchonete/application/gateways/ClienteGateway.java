package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;

public interface ClienteGateway {
    Cliente cadastraCliente(Cliente cliente);

    Cliente buscaClientePorCPF(String cpf);
}
