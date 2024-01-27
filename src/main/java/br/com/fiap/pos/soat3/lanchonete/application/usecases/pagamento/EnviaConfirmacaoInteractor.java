package br.com.fiap.pos.soat3.lanchonete.application.usecases.pagamento;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.EnviaConfirmacaoGateway;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento.ConfirmacaoResponse;

public class EnviaConfirmacaoInteractor {
    
    private final EnviaConfirmacaoGateway enviaConfirmacaoGateway;

    public EnviaConfirmacaoInteractor(EnviaConfirmacaoGateway enviaConfirmacaoGateway) {
        this.enviaConfirmacaoGateway = enviaConfirmacaoGateway;
    }
    
    public void execute(Long pedidoId, Long pagamentoId) {
        ConfirmacaoResponse response = enviaConfirmacaoGateway.enviaConfirmacaoMVP(pagamentoId);
//        atualizaStatusPedidoUseCasePort.execute(pedidoId, StatusPedido.valueOf(response.getResultado()));
    }
}
