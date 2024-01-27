package br.com.fiap.pos.soat3.lanchonete.domain.usecase.pagamento;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.integration.MVPResponse;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pagamento.RealizaPagamentoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.SalvaPedidoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.RecuperaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoMockPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

import java.math.BigDecimal;
import java.util.List;

public class RealizaPagamentoUseCase implements RealizaPagamentoUseCasePort {

    private final RealizaPagamentoAdapterPort realizaPagamentoAdapterPort;

    private final SalvaPedidoAdapterPort salvaPedidoAdapterPort;

    private final RealizaPagamentoMockPort realizaPagamentoMockPort;
    
    private final RecuperaProdutoUseCasePort recuperaProdutoUseCasePort;

    public RealizaPagamentoUseCase(RealizaPagamentoAdapterPort realizaPagamentoAdapterPort, SalvaPedidoAdapterPort salvaPedidoAdapterPort,
                                   RealizaPagamentoMockPort realizaPagamentoMockPort, RecuperaProdutoUseCasePort recuperaProdutoUseCasePort) {
        this.realizaPagamentoAdapterPort = realizaPagamentoAdapterPort;
        this.salvaPedidoAdapterPort = salvaPedidoAdapterPort;
        this.realizaPagamentoMockPort = realizaPagamentoMockPort;
        this.recuperaProdutoUseCasePort = recuperaProdutoUseCasePort;
    }

    @Override
    public Pagamento execute(Pagamento pagamento) {
        Pedido pedido = pagamento.getPedido();
        pedido.setStatus(StatusPedido.GERADO);
        pedido.setTotalPedido(getTotal(pedido.getItensPedido()));
        
        pagamento.setPedido(salvaPedidoAdapterPort.salvaPedido(pedido));
        MVPResponse response = realizaPagamentoMockPort.realizaPagamentoMVP(pagamento.getPedido().getId(), pagamento.getId());
        pagamento.setQrCode(response.getCode());
        pagamento.setWebhook(response.getUrl());
        return realizaPagamentoAdapterPort.realizaPagamento(pagamento);
    }

    private String getTotal(List<ItemPedido> itensPedido) {
        BigDecimal total = new BigDecimal("0");

        for (ItemPedido itemPedido : itensPedido) {
            String valorUnitario = String.valueOf(recuperaProdutoUseCasePort.execute(itemPedido.getProdutoId())
                    .getValor());
            BigDecimal valor = new BigDecimal(valorUnitario.replaceAll("\\.", "").replace(",", "."));

            BigDecimal multiplicador = new BigDecimal(itemPedido.getQuantidade());

            total = total.add(valor.multiply(multiplicador));
        }
        return String.valueOf(total);
    }
}
    
