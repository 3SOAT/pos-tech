package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

public interface ConsultaStatusPedidoAdapterPort {

    StatusPedido consultaStatusPedido(Long pedidoId);
}
