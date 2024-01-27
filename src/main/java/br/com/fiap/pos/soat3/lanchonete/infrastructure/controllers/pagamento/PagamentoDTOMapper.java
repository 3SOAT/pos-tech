package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.*;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria.CategoriaResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.BuscaPorCategoriaResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoResponse;

import java.math.BigDecimal;
import java.util.List;

public class PagamentoDTOMapper {
    public Pagamento toPagamento(PagamentoRequest request) {
        PedidoDTOMapper pedidoDTOMapper = new PedidoDTOMapper();
        List<ItemPedido> itensPedido = pedidoDTOMapper.toItemPedido(request.itensPedido());
        return new Pagamento(new Pedido(request.clienteId(), itensPedido));
    }

    ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getImagem(),
                produto.getValor().toPlainString(),
                new CategoriaResponse(produto.getCategoria().getId(), produto.getCategoria().getNome()));
    }

    BuscaPorCategoriaResponse toResponse(List<Produto> produtos) {

        List<ProdutoResponse> produtoResponse = produtos.stream()
                .map(produto -> new ProdutoResponse(produto.getId(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getImagem(),
                        produto.getValor().toPlainString(),
                        new CategoriaResponse(produto.getCategoria().getId(), produto.getCategoria().getNome())))
                .toList();

        return new BuscaPorCategoriaResponse(produtoResponse.size(), produtoResponse);
    }
}
