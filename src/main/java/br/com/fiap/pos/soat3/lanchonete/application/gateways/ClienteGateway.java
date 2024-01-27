package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;

public interface ClienteGateway {
    public Cliente criaCliente(Cliente cliente);
    public Cliente buscaClientePorCPF(String cpf);
}
