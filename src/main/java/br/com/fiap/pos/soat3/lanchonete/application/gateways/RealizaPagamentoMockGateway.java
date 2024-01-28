package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.integration.MVPResponse;

public interface RealizaPagamentoMockGateway {

    MVPResponse realizaPagamentoMVP(Long pedidoId, Long pagamentoId);
}
