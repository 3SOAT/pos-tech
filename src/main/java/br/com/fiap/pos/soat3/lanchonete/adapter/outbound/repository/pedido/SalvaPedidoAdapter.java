package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.mapper.PedidoMapper;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.SalvaPedidoAdapterPort;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SalvaPedidoAdapter implements SalvaPedidoAdapterPort {

    private final Logger log = LoggerFactory.getLogger(SalvaPedidoAdapter.class);

    private final PedidoRepository pedidoRepository;
    
    private final ItemPedidoRepository itemPedidoRepository;
    
    private final PedidoMapper pedidoMapper;
    

    public SalvaPedidoAdapter(PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    @Transactional
    public Pedido salvaPedido(Pedido pedido) {

        PedidoEntity pedidoEntity = pedidoMapper.getEntityFromDomain(pedido);
        pedido.setId(pedidoRepository.save(pedidoEntity).getId());
        salvaItemPedido(pedidoEntity);
        return pedido;
    }

    private void salvaItemPedido(PedidoEntity pedidoEntity) {
        for (ItemPedidoEntity itemPedidoEntity : pedidoEntity.getItensPedido()) {
            itemPedidoEntity.setPedido(pedidoEntity);
            itemPedidoRepository.save(itemPedidoEntity);
        }

        log.info(String.format("Lanchonete: Pedido criado %s", pedidoEntity.getId()));
    }
    
}
