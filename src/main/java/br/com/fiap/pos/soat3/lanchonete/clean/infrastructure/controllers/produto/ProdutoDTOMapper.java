package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response.CategoriaResponse;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Categoria;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Produto;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoDTOMapper {

    public Produto toProduto(CriaProdutoRequest request) {
        return new Produto(request.nome(),
                request.descricao(),
                request.imagem(),
                new BigDecimal(request.valor()),
                new Categoria(request.categoriaId()));
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
