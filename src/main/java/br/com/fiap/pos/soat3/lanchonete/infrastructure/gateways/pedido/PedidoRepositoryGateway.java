package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.itemPedido.ItemPedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.itemPedido.ItemPedidoRepository;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoRepository;

public class PedidoRepositoryGateway implements PedidoGateway {

    private final PedidoRepository pedidoRepository;

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoEntityMapper pedidoEntityMapper;

    public PedidoRepositoryGateway(PedidoRepository pedidoRepository,
                                   ItemPedidoRepository itemPedidoRepository,
                                   PedidoEntityMapper pedidoEntityMapper) {
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
    }

    @Override
    public Pedido cadastraPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoEntityMapper.toEntity(pedido);
        pedido.setId(pedidoRepository.save(pedidoEntity).getId());
        salvaItemPedido(pedidoEntity);
        return pedido;
    }

    private void salvaItemPedido(PedidoEntity pedidoEntity) {
        for (ItemPedidoEntity itemPedidoEntity : pedidoEntity.getItensPedido()) {
            itemPedidoEntity.setPedido(pedidoEntity);
            itemPedidoRepository.save(itemPedidoEntity);
        }

        //log.info(String.format("Lanchonete: Pedido criado %s", pedidoEntity.getId()));
    }
}
