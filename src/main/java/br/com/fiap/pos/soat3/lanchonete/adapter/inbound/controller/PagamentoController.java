package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller;

import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.request.PagamentoRequest;
import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response.PagamentoResponse;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pagamento.EnviaConfirmacaoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pagamento.RealizaPagamentoUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final RealizaPagamentoUseCasePort realizaPagamentoUseCasePort;
    
    private final EnviaConfirmacaoUseCasePort enviaConfirmacaoUseCasePort;

    public PagamentoController(RealizaPagamentoUseCasePort realizaPagamentoUseCasePort, EnviaConfirmacaoUseCasePort enviaConfirmacaoUseCasePort) {
        this.realizaPagamentoUseCasePort = realizaPagamentoUseCasePort;
        this.enviaConfirmacaoUseCasePort = enviaConfirmacaoUseCasePort;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> realizaPagamento(@Valid @RequestBody PagamentoRequest pagamentoRequest) {
        return ResponseEntity.ok(PagamentoResponse.fromDomain(realizaPagamentoUseCasePort.execute(pagamentoRequest.toDomain())));
    }

    @PatchMapping("/{pagamentoId}/pedido/{pedidoId}/envia-confirmacao")
    public ResponseEntity<PagamentoResponse> enviaConfirmacaoPagamento(@PathVariable("pedidoId") final Long pedidoId, @PathVariable("pagamentoId") final Long pagamentoId) {
        enviaConfirmacaoUseCasePort.execute(pedidoId, pagamentoId);
        return ResponseEntity.ok().build();
    }
}
