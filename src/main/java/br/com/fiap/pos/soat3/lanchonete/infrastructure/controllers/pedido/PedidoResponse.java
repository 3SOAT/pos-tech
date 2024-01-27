package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.StatusPedido;

import java.util.List;

public record PedidoResponse(Long id, Long clienteId, List<ItemPedidoResponse> itensPedido, String totalPedido, StatusPedido status) {
}
