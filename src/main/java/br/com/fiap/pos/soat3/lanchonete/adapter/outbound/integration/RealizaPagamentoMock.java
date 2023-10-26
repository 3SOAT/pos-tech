package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.integration;


import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoMockPort;
import org.springframework.stereotype.Component;

@Component
public class RealizaPagamentoMock implements RealizaPagamentoMockPort {

    private final MVPCliente mVPCliente;

    public RealizaPagamentoMock(MVPCliente mVPCliente) {
        this.mVPCliente = mVPCliente;
    }

    @Override
    public String realizaPagamentoMVP(Long pedidoId) {
        return mVPCliente.realizaPagamentoMock(pedidoId);
    }
}
