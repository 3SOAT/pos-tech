package br.com.fiap.pos.soat3.lanchonete.domain.usecase;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.RealizaPagamentoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RealizaPagamentoAdapterPort;

public class RealizaPagamentoUseCase implements RealizaPagamentoUseCasePort {

    private final RealizaPagamentoAdapterPort realizaPagamentoAdapterPort;

    public RealizaPagamentoUseCase(RealizaPagamentoAdapterPort realizaPagamentoAdapterPort) {
        this.realizaPagamentoAdapterPort = realizaPagamentoAdapterPort;
    }

    @Override
    public Pagamento execute(Pagamento pagamento) {
        return realizaPagamentoAdapterPort.realizaPagamento(pagamento);
    }
}
