package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.mapper;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.ItemPedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.PedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoMapper {

    public Pedido fromEntity(PedidoEntity pedidoEntity) {
        return new Pedido(
                pedidoEntity.getId(),
                pedidoEntity.getClientId(),
                itemPedidoFromEntity(pedidoEntity.getItensPedido()),
                pedidoEntity.getDataDeCriacao(),
                pedidoEntity.getTotalPedido()
        );
    }

    public PedidoEntity getEntityFromDomain(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        List<ItemPedidoEntity> itensPedidoEntity = new ArrayList<>();
        addItems(pedido, itensPedidoEntity);
        pedidoEntity.setClientId(pedido.getClienteId());
        pedidoEntity.setItensPedido(itensPedidoEntity);
        pedidoEntity.setDataDeCriacao(LocalDateTime.now());
        pedidoEntity.setTotalPedido(pedido.getTotalPedido());
        return pedidoEntity;
    }

    private static void addItems(Pedido pedido, List<ItemPedidoEntity> itensPedidoEntity) {
        pedido.getItensPedido().forEach(item ->
                itensPedidoEntity.add(new ItemPedidoEntity(item.getProdutoId(), item.getQuantidade()))
        );
    }

    public static List<ItemPedido> itemPedidoFromEntity(List<ItemPedidoEntity> items) {
        var lista = new ArrayList<ItemPedido>();

        items.forEach(pedido ->
                lista.add(new ItemPedido(
                        pedido.getProdutoId(),
                        pedido.getQuantidade()
                ))
        );

        return lista;
    }

}
