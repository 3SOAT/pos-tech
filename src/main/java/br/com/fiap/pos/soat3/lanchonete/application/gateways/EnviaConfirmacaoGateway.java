package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento.ConfirmacaoResponse;

public interface EnviaConfirmacaoGateway {
    ConfirmacaoResponse enviaConfirmacaoMVP(Long pagamentoId);
}
