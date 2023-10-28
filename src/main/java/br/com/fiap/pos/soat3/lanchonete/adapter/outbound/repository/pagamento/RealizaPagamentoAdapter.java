package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoAdapterPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RealizaPagamentoAdapter implements RealizaPagamentoAdapterPort {

    private final Logger log = LoggerFactory.getLogger(RealizaPagamentoAdapter.class);

    private final PagamentoRepository pagamentoRepository;

    public RealizaPagamentoAdapter(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Pagamento realizaPagamento(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId(pagamento.getPedido().getId());
        pagamentoEntity.setQrCode(pagamento.getQrCode());
        pagamento.setId(pagamentoRepository.save(pagamentoEntity).getId());

        log.info(String.format("Lanchonete: Pagemento do pedido  %s realizado", pagamento.getPedido().getId()));
        return pagamento;
    }
}
