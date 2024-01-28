package br.com.fiap.pos.soat3.lanchonete.infrastructure.integration;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento.ConfirmacaoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface MVPCliente {

    MVPResponse realizaPagamentoMock(Long pedidoId, Long pagamentoId);

    @GetMapping("/mock/{pagamentoId}")
    ResponseEntity<ConfirmacaoResponse> verificaPagamentoMock(@PathVariable("pagamentoId") Long pagamentoId);
}
