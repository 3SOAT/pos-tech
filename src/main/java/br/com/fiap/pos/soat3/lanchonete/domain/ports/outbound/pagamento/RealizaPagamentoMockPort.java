package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.integration.MVPResponse;

public interface RealizaPagamentoMockPort {

    MVPResponse realizaPagamentoMVP(Long pedidoId, Long pagamentoId);
}
