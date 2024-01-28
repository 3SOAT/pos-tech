package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;

public record ItemPedidoRequest(Long produtoId, int quantidade) {
}
