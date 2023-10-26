package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;

public interface RealizaPagamentoAdapterPort {
    
    Pagamento realizaPagamento(Pagamento pagamento);
}
