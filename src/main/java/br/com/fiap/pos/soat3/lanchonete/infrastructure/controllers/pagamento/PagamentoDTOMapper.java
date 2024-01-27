package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.*;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.ItemPedidoResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.BuscaPorCategoriaResponse;

import java.math.BigDecimal;
import java.util.List;

public class PagamentoDTOMapper {
    public Pagamento toPagamento(PagamentoRequest request) {
        PedidoDTOMapper pedidoDTOMapper = new PedidoDTOMapper();
        List<ItemPedido> itensPedido = pedidoDTOMapper.toItemPedido(request.itensPedido());
        return new Pagamento(new Pedido(request.clienteId(), itensPedido));
    }

    PagamentoResponse toResponse(Pagamento pagamento) {

        List<ItemPedidoResponse> itensPedidoResponse = pagamento.getPedido().getItensPedido().stream()
                .map(item -> new ItemPedidoResponse(item.getProdutoId(), item.getQuantidade()))
                .toList();
        PedidoResponse pedidoResponse = new PedidoResponse(pagamento.getPedido().getId(),
                pagamento.getPedido().getClienteId(),
                itensPedidoResponse,
                pagamento.getPedido().getTotalPedido(),
                pagamento.getPedido().getStatus());

        return new PagamentoResponse(pagamento.getId(), pedidoResponse, pagamento.getQrCode());
    }
}
