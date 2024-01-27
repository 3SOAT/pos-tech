package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pagamento;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.PagamentoGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.RealizaPagamentoMockGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.*;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido.PedidoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto.ProdutoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pagamento.PagamentoRepository;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;


public class PagamentoRepositoryGateway implements PagamentoGateway {

    private final Logger log = LoggerFactory.getLogger(PagamentoRepositoryGateway.class);
    private PagamentoRepository pagamentoRepository;

    private PedidoRepositoryGateway pedidoRepositoryGateway;
    private ProdutoRepositoryGateway produtoRepositoryGateway;
    private PagamentoEntityMapper pagamentoEntityMapper;
    private RealizaPagamentoMockGateway realizaPagamentoMockGateway;

    public PagamentoRepositoryGateway(PagamentoRepository pagamentoRepository,
                                      PedidoRepositoryGateway pedidoRepositoryGateway,
                                      ProdutoRepositoryGateway produtoRepositoryGateway,
                                      PagamentoEntityMapper pagamentoEntityMapper,
                                      RealizaPagamentoMockGateway realizaPagamentoMockGateway) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepositoryGateway = pedidoRepositoryGateway;
        this.produtoRepositoryGateway = produtoRepositoryGateway;
        this.pagamentoEntityMapper = pagamentoEntityMapper;
        this.realizaPagamentoMockGateway = realizaPagamentoMockGateway;

    }

    @Override
    public Pagamento realizaPagamento(Pagamento pagamento) {

        Pedido pedido = pagamento.getPedido();
        pedido.setStatus(StatusPedido.GERADO);
        pedido.setTotalPedido(getTotal(pedido.getItensPedido()));

        pagamento.setPedido(pedidoRepositoryGateway.cadastraPedido(pedido));
        pagamento.setQrCode(realizaPagamentoMockGateway.realizaPagamentoMVP(pagamento.getPedido().getId()));



        var pagamentoEntity = pagamentoEntityMapper.toEntity(pagamento);
        pagamento.setId(pagamentoRepository.save(pagamentoEntity).getId());
        // É necessário tratar se o pagamento foi realizado com sucesso ou não
        pagamento.getPedido().setStatus(StatusPedido.RECEBIDO);
        log.info(String.format("Lanchonete: Pagemento do pedido  %s realizado", pagamento.getPedido().getId()));
        return pagamento;


    }

    private String getTotal(List<ItemPedido> itensPedido) {
        BigDecimal total = new BigDecimal("0");

        for (ItemPedido itemPedido : itensPedido) {
            Produto produto = produtoRepositoryGateway.buscaProduto(itemPedido.getProdutoId());
                String valorUnitario = String.valueOf(produto.getValor());
                BigDecimal valor = new BigDecimal(valorUnitario.replaceAll("\\.", "").replace(",", "."));

                BigDecimal multiplicador = new BigDecimal(itemPedido.getQuantidade());

                total = total.add(valor.multiply(multiplicador));
        }
        return String.valueOf(total);
    }
}
