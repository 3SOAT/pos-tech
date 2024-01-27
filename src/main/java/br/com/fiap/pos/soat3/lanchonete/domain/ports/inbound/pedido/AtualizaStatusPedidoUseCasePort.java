package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

import java.util.List;

public interface AtualizaStatusPedidoUseCasePort {

    Pedido execute(Long pedidoId, StatusPedido statusPedido);
}
