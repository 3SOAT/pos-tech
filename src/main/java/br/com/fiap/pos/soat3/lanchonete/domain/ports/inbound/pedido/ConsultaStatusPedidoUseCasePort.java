package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

public interface ConsultaStatusPedidoUseCasePort {

    StatusPedido execute(Long pedidoId);
}
