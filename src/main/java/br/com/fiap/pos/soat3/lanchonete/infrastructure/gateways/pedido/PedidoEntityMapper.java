package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.itemPedido.ItemPedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoEntityMapper {

    PedidoEntity toEntity(Pedido pedidoDomainObj) {

        PedidoEntity pedidoEntity = new PedidoEntity();
        List<ItemPedidoEntity> itensPedidoEntity = new ArrayList<>();
        addItems(pedidoDomainObj, itensPedidoEntity);
        pedidoEntity.setClientId(pedidoDomainObj.getClienteId());
        pedidoEntity.setItensPedido(itensPedidoEntity);
        pedidoEntity.setDataDeCriacao(LocalDateTime.now());
        pedidoEntity.setTotalPedido(pedidoDomainObj.getTotalPedido());
        pedidoEntity.setStatus(pedidoDomainObj.getStatus());
        return pedidoEntity;
    }

    private static void addItems(Pedido pedido, List<ItemPedidoEntity> itensPedidoEntity) {
        pedido.getItensPedido().forEach(item ->
                itensPedidoEntity.add(new ItemPedidoEntity(item.getProdutoId(), item.getQuantidade()))
        );
    }

    Pedido toDomainObj(PedidoEntity pedidoEntity) {
        return new Pedido();
    }
}
