package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;

public interface PedidoGateway {
    Pedido cadastraPedido(Pedido pedido);
}
