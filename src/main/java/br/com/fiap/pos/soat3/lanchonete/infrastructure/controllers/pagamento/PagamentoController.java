package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.pagamento.RealizaPagamentoInteractor;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pagamento;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final RealizaPagamentoInteractor realizaPagamentoUseCase;
    private final PagamentoDTOMapper pagamentoDTOMapper;

    public PagamentoController(RealizaPagamentoInteractor realizaPagamentoUseCase, PagamentoDTOMapper pagamentoDTOMapper) {
        this.realizaPagamentoUseCase = realizaPagamentoUseCase;
        this.pagamentoDTOMapper = pagamentoDTOMapper;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> realizaPagamento(@Valid @RequestBody PagamentoRequest pagamentoRequest) {
        Pagamento pagamentoObj = pagamentoDTOMapper.toPagamento(pagamentoRequest);
        Pagamento pagamento = realizaPagamentoUseCase.realizaPagamento(pagamentoObj);
        return ResponseEntity.ok(pagamentoDTOMapper.toResponse(pagamento));
    }
}
