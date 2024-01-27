package br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.AtualizaStatusPedidoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.AtualizaStatusPedidoAdapterPort;

public class AtualizaStatusPedidoUseCase implements AtualizaStatusPedidoUseCasePort {

    private final AtualizaStatusPedidoAdapterPort atualizaStatusPedido;

    public AtualizaStatusPedidoUseCase(AtualizaStatusPedidoAdapterPort atualizaStatusPedido) {
        this.atualizaStatusPedido = atualizaStatusPedido;
    }

    @Override
    public Pedido execute(Long pedidoId, StatusPedido status) {
        return atualizaStatusPedido.atualizaStatusPedido(pedidoId, status);
    }
}
