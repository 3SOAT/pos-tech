package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;

public interface SalvaClienteAdapterPort {

    Cliente saveCliente(Cliente cliente);
}
