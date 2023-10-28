package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido;


import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto.ProdutoRepository;
import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.SalvaPedidoAdapterPort;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SalvaPedidoAdapter implements SalvaPedidoAdapterPort {

    private final Logger log = LoggerFactory.getLogger(SalvaPedidoAdapter.class);

    private final PedidoRepository pedidoRepository;

    private final ProdutoRepository produtoRepository;
    
    private final ItemPedidoRepository itemPedidoRepository;


    public SalvaPedidoAdapter(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, ItemPedidoRepository itemPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @Override
    @Transactional
    public Pedido salvaPedido(Pedido pedido) {
        //TODO: COMO PODEMOS MELHORAR ESSE METODO?
        
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setClientId(pedido.getClienteId());

        List<ItemPedidoEntity> itensPedidoEntity = new ArrayList<>();

        pedido.getItensPedido().forEach(item -> 
                itensPedidoEntity.add(new ItemPedidoEntity(item.getProdutoId(), item.getQuantidade()))
        );
        pedidoEntity.setItensPedido(itensPedidoEntity);
        pedidoEntity.setDataDeCriacao(LocalDateTime.now());
        
        pedidoEntity.setTotalPedido(getTotal(pedido.getItensPedido()));
        pedido.setTotalPedido(pedidoEntity.getTotalPedido());
        pedido.setId(pedidoRepository.save(pedidoEntity).getId());

        for (ItemPedidoEntity itemPedidoEntity : pedidoEntity.getItensPedido()) {
            itemPedidoEntity.setPedido(pedidoEntity);
            itemPedidoRepository.save(itemPedidoEntity);
        }

        log.info(String.format("Lanchonete: Pedido criado %s", pedido.getId()));
        return pedido;
    }
    
    private String getTotal(List<ItemPedido> itensPedido){
        BigDecimal total = new BigDecimal("0");

        for (ItemPedido itemPedido: itensPedido){
            String valorUnitario = produtoRepository.findById(itemPedido.getProdutoId())
                    .orElseThrow(() -> new EntityNotFoundException("Produto", String.valueOf(itemPedido.getProdutoId())))
                    .getValor();
            BigDecimal valor = new BigDecimal(valorUnitario.replaceAll("\\.", "").replace(",","."));

            BigDecimal multiplicador = new BigDecimal(itemPedido.getQuantidade());

            total = total.add(valor.multiply(multiplicador));
        }
        return String.valueOf(total);
    }
}
