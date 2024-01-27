package br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.PedidoGateway;

public class ListaPedidosInteractor {
    private final PedidoGateway pedidoGateway;

    public ListaPedidosInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }
}
