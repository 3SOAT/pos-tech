package br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.ConsultaStatusPedidoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.ConsultaStatusPedidoAdapterPort;

public class ConsultaStatusPedidoUseCase implements ConsultaStatusPedidoUseCasePort {

    private final ConsultaStatusPedidoAdapterPort consultaStatusPedidoAdapter;

    public ConsultaStatusPedidoUseCase(ConsultaStatusPedidoAdapterPort consultaStatusPedidoAdapterPort) {
        this.consultaStatusPedidoAdapter = consultaStatusPedidoAdapterPort;
    }

    @Override
    public StatusPedido execute(Long pedidoId) {
        return consultaStatusPedidoAdapter.consultaStatusPedido(pedidoId);
    }
}
