package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoRepository;

public class PedidoRepositoryGateway implements PedidoGateway {

    private PedidoRepository pedidoRepository;
    private PedidoEntityMapper pedidoEntityMapper;

    public PedidoRepositoryGateway(PedidoRepository pedidoRepository, PedidoEntityMapper pedidoEntityMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
    }

    @Override
    public Pedido cadastraPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoEntityMapper.toEntity(pedido);
        pedido.setId(pedidoRepository.save(pedidoEntity).getId());
        //salvaItemPedido(pedidoEntity);
        return pedido;
    }
}
