package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

import java.util.List;

public interface AtualizaStatusPedidoAdapterPort {

    Pedido atualizaStatusPedido(Long pedidoId, StatusPedido statusPedido);
}
