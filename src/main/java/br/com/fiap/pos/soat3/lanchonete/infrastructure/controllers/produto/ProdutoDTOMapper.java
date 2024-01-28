package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria.CategoriaResponse;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoDTOMapper {

    public Produto toProduto(ProdutoRequest request) {
        return new Produto(request.nome(),
                request.descricao(),
                request.imagem(),
                request.valor() != null ? new BigDecimal(request.valor()) : null,
                request.categoriaId() != null ? new Categoria(request.categoriaId()) : null);
    }

    public Produto toProduto(Long id, ProdutoRequest request) {
        return new Produto(id,
                request.nome(),
                request.descricao(),
                request.imagem(),
                request.valor() != null ? new BigDecimal(request.valor()) : null,
                request.categoriaId() != null ? new Categoria(request.categoriaId()) : null);
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
