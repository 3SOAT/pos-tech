package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pagamento.mapper;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pagamento.PagamentoEntity;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

    public PagamentoEntity getEntityFromDomain(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId(pagamento.getPedido().getId());
        pagamentoEntity.setQrCode(pagamento.getQrCode());
        return pagamentoEntity;
    }

}
