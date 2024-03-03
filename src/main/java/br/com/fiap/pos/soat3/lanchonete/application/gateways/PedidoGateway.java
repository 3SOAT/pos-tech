package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;

import java.util.List;

public interface PedidoGateway {
    Pedido cadastraPedido(Pedido pedido);

    List<Pedido> listaPedidos();

    String consultaStatusPedido(Long pedidoId);

    Pedido atualizaStatusPedido(Long pedidoId, String statusPedido);

}
