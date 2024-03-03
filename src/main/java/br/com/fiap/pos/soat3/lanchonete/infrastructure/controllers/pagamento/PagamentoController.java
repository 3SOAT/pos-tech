package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.pagamento.EnviaConfirmacaoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pagamento.RealizaPagamentoInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pagamento;
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

    private final RealizaPagamentoInteractor realizaPagamentoInteractor;

    private final EnviaConfirmacaoInteractor enviaConfirmacaoInteractor;
    private final PagamentoDTOMapper pagamentoDTOMapper;

    public PagamentoController(RealizaPagamentoInteractor realizaPagamentoInteractor,
                               EnviaConfirmacaoInteractor enviaConfirmacaoInteractor,
                               PagamentoDTOMapper pagamentoDTOMapper) {
        this.realizaPagamentoInteractor = realizaPagamentoInteractor;
        this.enviaConfirmacaoInteractor = enviaConfirmacaoInteractor;
        this.pagamentoDTOMapper = pagamentoDTOMapper;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> realizaPagamento(@Valid @RequestBody PagamentoRequest pagamentoRequest) {
        Pagamento pagamentoObj = pagamentoDTOMapper.toPagamento(pagamentoRequest);
        Pagamento pagamento = realizaPagamentoInteractor.realizaPagamento(pagamentoObj);
        return ResponseEntity.ok(pagamentoDTOMapper.toResponse(pagamento));
    }

    @PatchMapping("/{pagamentoId}/pedido/{pedidoId}/envia-confirmacao")
    public ResponseEntity<PagamentoResponse> enviaConfirmacaoPagamento(@PathVariable("pedidoId") final Long pedidoId,
                                                                       @PathVariable("pagamentoId") final Long pagamentoId) {
        enviaConfirmacaoInteractor.enviaConfirmacao(pedidoId, pagamentoId);
        return ResponseEntity.ok().build();
    }
}
