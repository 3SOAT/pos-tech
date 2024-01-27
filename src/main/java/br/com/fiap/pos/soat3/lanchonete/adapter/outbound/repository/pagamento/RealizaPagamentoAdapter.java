package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pagamento;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pagamento.mapper.PagamentoMapper;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RealizaPagamentoAdapter implements RealizaPagamentoAdapterPort {

    private final Logger log = LoggerFactory.getLogger(RealizaPagamentoAdapter.class);

    private final PagamentoRepository pagamentoRepository;

    private final PagamentoMapper pagamentoMapper;

    public RealizaPagamentoAdapter(PagamentoRepository pagamentoRepository, PagamentoMapper pagamentoMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoMapper = pagamentoMapper;
    }

    @Override
    public Pagamento realizaPagamento(Pagamento pagamento) {
        var pagamentoEntity = pagamentoMapper.getEntityFromDomain(pagamento);
        pagamento.setId(pagamentoRepository.save(pagamentoEntity).getId());
        // É necessário tratar se o pagamento foi realizado com sucesso ou não
        pagamento.getPedido().setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        log.info(String.format("Lanchonete: Pagamento do pedido  %s gerado", pagamento.getPedido().getId()));
        return pagamento;
    }
}
