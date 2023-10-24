package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;

public interface RealizaPagamentoUseCasePort {

    Pagamento execute(Pagamento pagamento);
}
