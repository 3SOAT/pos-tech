package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;

import java.util.List;

public interface ListaPedidosAdapterPort {

    List<Pedido> listaPedidos();
}
