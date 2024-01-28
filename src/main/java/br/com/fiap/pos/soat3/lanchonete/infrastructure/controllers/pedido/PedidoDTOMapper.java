package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTOMapper {

    public List<ItemPedido> toItemPedido(List<ItemPedidoRequest> request) {

        List<ItemPedido> itensPedido = request.stream().
                map(item -> new ItemPedido(item.produtoId(), item.quantidade())).toList();

        return itensPedido;
    }

    public PedidoResponse toPedidoResponse(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getClienteId(), pedido.getItensPedido(),
                pedido.getTotalPedido(), pedido.getStatus());
    }

    public List<PedidoResponse> toPedidoResponseList(List<Pedido> pedidos) {
        var lista = new ArrayList<PedidoResponse>();

        pedidos.forEach(pedido ->
                lista.add(
                        new PedidoResponse(
                                pedido.getId(),
                                pedido.getClienteId(),
                                pedido.getItensPedido(),
                                pedido.getTotalPedido(),
                                pedido.getStatus()
                        )
                )
        );

        return lista;
    }

    public StatusPedidoResponse toStatusPedidoResponse(String status) {
        return new StatusPedidoResponse(status);
    }
}
