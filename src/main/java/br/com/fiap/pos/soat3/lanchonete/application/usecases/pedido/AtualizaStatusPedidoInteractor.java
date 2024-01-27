package br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.PagamentoGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.PedidoGateway;

public class AtualizaStatusPedidoInteractor {
    private final PedidoGateway pedidoGateway;

    public AtualizaStatusPedidoInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }
}
