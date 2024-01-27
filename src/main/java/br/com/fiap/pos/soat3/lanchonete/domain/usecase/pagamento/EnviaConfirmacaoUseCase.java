package br.com.fiap.pos.soat3.lanchonete.domain.usecase.pagamento;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.integration.ConfirmacaoResponse;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pagamento.EnviaConfirmacaoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.AtualizaStatusPedidoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.EnviaConfirmacaoPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

public class EnviaConfirmacaoUseCase implements EnviaConfirmacaoUseCasePort {
    
    private final AtualizaStatusPedidoUseCasePort atualizaStatusPedidoUseCasePort;
    
    private final EnviaConfirmacaoPort enviaConfirmacaoPort;

    public EnviaConfirmacaoUseCase(AtualizaStatusPedidoUseCasePort atualizaStatusPedidoUseCasePort, 
                                   EnviaConfirmacaoPort enviaConfirmacaoPort) {
        this.atualizaStatusPedidoUseCasePort = atualizaStatusPedidoUseCasePort;
        this.enviaConfirmacaoPort = enviaConfirmacaoPort;
    }

    @Override
    public void execute(Long pedidoId, Long pagamentoId) {
        ConfirmacaoResponse response = enviaConfirmacaoPort.enviaConfirmacaoMVP(pagamentoId);
        atualizaStatusPedidoUseCasePort.execute(pedidoId, StatusPedido.valueOf(response.getResultado()));
    }
}
