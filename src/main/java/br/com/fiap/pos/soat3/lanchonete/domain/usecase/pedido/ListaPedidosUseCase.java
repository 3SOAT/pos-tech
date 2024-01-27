package br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.ListaPedidosUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.ListaPedidosAdapterPort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaPedidosUseCase implements ListaPedidosUseCasePort {

    private final ListaPedidosAdapterPort listaPedidosAdapterPort;

    public ListaPedidosUseCase(ListaPedidosAdapterPort listaPedidosAdapterPort) {
        this.listaPedidosAdapterPort = listaPedidosAdapterPort;
    }

    @Override
    public List<Pedido> execute() {
        return orderList(listaPedidosAdapterPort.listaPedidos());
    }

    private List<Pedido> orderList(List<Pedido> list) {
        Comparator<Pedido> comparadorStatus = Comparator.comparingInt(pedido -> {
            switch (pedido.getStatus()) {
                case PRONTO:
                    return 0;
                case PREPARACAO:
                    return 1;
                case RECEBIDO:
                    return 2;
                default:
                    return 3;
            }
        });

        comparadorStatus = comparadorStatus.thenComparing(Pedido::getDataDeCriacao).reversed();

        list.sort(comparadorStatus);
        return list;
    }
}
