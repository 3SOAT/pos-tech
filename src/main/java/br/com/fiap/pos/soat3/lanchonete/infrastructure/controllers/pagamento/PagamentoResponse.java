package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoResponse;

public record PagamentoResponse(Long id, PedidoResponse pedido, String qrCode) {
}
