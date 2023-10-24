package br.com.fiap.pos.soat3.lanchonete.domain.usecase.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pagamento.RealizaPagamentoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.SalvaPedidoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoMockPort;

public class RealizaPagamentoUseCase implements RealizaPagamentoUseCasePort {

    private final RealizaPagamentoAdapterPort realizaPagamentoAdapterPort;
    
    private final SalvaPedidoAdapterPort salvaPedidoAdapterPort;
    
    private final RealizaPagamentoMockPort realizaPagamentoMockPort;

    public RealizaPagamentoUseCase(RealizaPagamentoAdapterPort realizaPagamentoAdapterPort, SalvaPedidoAdapterPort salvaPedidoAdapterPort, RealizaPagamentoMockPort realizaPagamentoMockPort) {
        this.realizaPagamentoAdapterPort = realizaPagamentoAdapterPort;
        this.salvaPedidoAdapterPort = salvaPedidoAdapterPort;
        this.realizaPagamentoMockPort = realizaPagamentoMockPort;
    }

    @Override
    public Pagamento execute(Pagamento pagamento) {
        Pedido pedido = salvaPedidoAdapterPort.salvaPedido(pagamento.getPedido());
        pagamento.setPedido(pedido);
        pagamento.setQrCode(realizaPagamentoMockPort.realizaPagamentoMVP(pedido.getId()));
        return realizaPagamentoAdapterPort.realizaPagamento(pagamento);
    }
}
    
