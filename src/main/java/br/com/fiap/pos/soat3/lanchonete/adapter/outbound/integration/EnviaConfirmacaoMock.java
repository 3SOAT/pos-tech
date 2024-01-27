package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.integration;

import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.EnviaConfirmacaoPort;
import org.springframework.stereotype.Component;

@Component
public class EnviaConfirmacaoMock implements EnviaConfirmacaoPort {

    private final MVPCliente mVPCliente;

    public EnviaConfirmacaoMock(MVPCliente mVPCliente) {
        this.mVPCliente = mVPCliente;
    }
    
    @Override
    public ConfirmacaoResponse enviaConfirmacaoMVP(Long pagamentoId) {
        return mVPCliente.verificaPagamentoMock(pagamentoId).getBody();
    }
}
