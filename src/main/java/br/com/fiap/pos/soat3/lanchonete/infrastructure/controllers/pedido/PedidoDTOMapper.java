package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria.CategoriaResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.BuscaPorCategoriaResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoRequest;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoResponse;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTOMapper {

    public List<ItemPedido> toItemPedido(List<ItemPedidoRequest> request) {

        List<ItemPedido> itensPedido = request.stream().
                map(item -> new ItemPedido(item.produtoId(), item.quantidade())).toList();

        return itensPedido;
    }

//    public Pedido toPedido(ProdutoRequest request) {
//        return new Produto(request.nome(),
//                request.descricao(),
//                request.imagem(),
//                new BigDecimal(request.valor()),
//                new Categoria(request.categoriaId()));
//    }
//
//    public Produto toProduto(Long id, ProdutoRequest request) {
//        return new Produto(id,
//                request.nome(),
//                request.descricao(),
//                request.imagem(),
//                new BigDecimal(request.valor()),
//                new Categoria(request.categoriaId()));
//    }
//
//    ProdutoResponse toResponse(Produto produto) {
//        return new ProdutoResponse(produto.getId(),
//                produto.getNome(),
//                produto.getDescricao(),
//                produto.getImagem(),
//                produto.getValor().toPlainString(),
//                new CategoriaResponse(produto.getCategoria().getId(), produto.getCategoria().getNome()));
//    }
//
//    BuscaPorCategoriaResponse toResponse(List<Produto> produtos) {
//
//        List<ProdutoResponse> produtoResponse = produtos.stream()
//                .map(produto -> new ProdutoResponse(produto.getId(),
//                        produto.getNome(),
//                        produto.getDescricao(),
//                        produto.getImagem(),
//                        produto.getValor().toPlainString(),
//                        new CategoriaResponse(produto.getCategoria().getId(), produto.getCategoria().getNome())))
//                .toList();
//
//        return new BuscaPorCategoriaResponse(produtoResponse.size(), produtoResponse);
//    }
}
