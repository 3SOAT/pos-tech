package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoResponse;

import java.util.List;

public class PagamentoDTOMapper {
    public Pagamento toPagamento(PagamentoRequest request) {
        PedidoDTOMapper pedidoDTOMapper = new PedidoDTOMapper();
        List<ItemPedido> itensPedido = pedidoDTOMapper.toItemPedido(request.itensPedido());
        return new Pagamento(new Pedido(request.clienteId(), itensPedido));
    }

    PagamentoResponse toResponse(Pagamento pagamento) {
        PedidoResponse pedidoResponse = new PedidoResponse(pagamento.getPedido().getId(),
                pagamento.getPedido().getClienteId(),
                pagamento.getPedido().getItensPedido(),
                pagamento.getPedido().getTotalPedido(),
                pagamento.getPedido().getStatus());

        return new PagamentoResponse(pagamento.getId(), pedidoResponse, pagamento.getQrCode());
    }
}
