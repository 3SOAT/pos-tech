package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.integration.ConfirmacaoResponse;

public interface EnviaConfirmacaoPort {

    ConfirmacaoResponse enviaConfirmacaoMVP(Long pagamentoId);

}
