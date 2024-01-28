package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pagamento.PagamentoEntity;

public class PagamentoEntityMapper {
    PagamentoEntity toEntity(Pagamento pagamentoDomainObj) {

        return new PagamentoEntity(pagamentoDomainObj.getPedido().getId(), pagamentoDomainObj.getQrCode(), pagamentoDomainObj.getWebhook());
    }
}
