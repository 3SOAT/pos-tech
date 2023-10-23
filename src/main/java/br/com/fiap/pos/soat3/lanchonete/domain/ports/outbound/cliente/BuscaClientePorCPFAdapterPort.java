package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;

public interface BuscaClientePorCPFAdapterPort {

    Cliente buscaCliente(String cpf);
}
