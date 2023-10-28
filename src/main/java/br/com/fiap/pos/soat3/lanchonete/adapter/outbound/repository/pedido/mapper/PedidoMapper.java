package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.mapper;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.PedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido fromEntity(PedidoEntity pedidoEntity) {
        return new Pedido(
                pedidoEntity.getId(),
                pedidoEntity.getClientId(),
                ItemPedido.fromEntity(pedidoEntity.getItensPedido()),
                pedidoEntity.getDataDeCriacao(),
                pedidoEntity.getTotalPedido()
        );
    }

}
