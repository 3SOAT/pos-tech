package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;

import java.util.List;

public interface ListaPedidosUseCasePort {

    List<Pedido> execute();
}
