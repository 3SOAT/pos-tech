package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pagamento;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.PagamentoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pagamento.PagamentoRepository;

public class PagamentoRepositoryGateway implements PagamentoGateway {

    private PagamentoRepository pagamentoRepository;
    private PagamentoEntityMapper pagamentoEntityMapper;

    public PagamentoRepositoryGateway(PagamentoRepository pagamentoRepository, PagamentoEntityMapper pagamentoEntityMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoEntityMapper = pagamentoEntityMapper;
    }

    @Override
    public Pagamento realizaPagamento(Pagamento pagamento) {
        return null;
    }
}
