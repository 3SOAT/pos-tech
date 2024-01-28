package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pagamento;

public interface PagamentoGateway {
    Pagamento realizaPagamento(Pagamento pagamento);
}
