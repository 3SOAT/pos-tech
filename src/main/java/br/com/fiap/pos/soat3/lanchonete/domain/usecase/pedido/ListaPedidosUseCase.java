package br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.ListaPedidosUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.ListaPedidosAdapterPort;
import java.util.List;

public class ListaPedidosUseCase implements ListaPedidosUseCasePort {

    private final ListaPedidosAdapterPort listaPedidosAdapterPort;

    public ListaPedidosUseCase(ListaPedidosAdapterPort listaPedidosAdapterPort) {
        this.listaPedidosAdapterPort = listaPedidosAdapterPort;
    }

    @Override
    public List<Pedido> execute() {
        return listaPedidosAdapterPort.listaPedidos();
    }
}
