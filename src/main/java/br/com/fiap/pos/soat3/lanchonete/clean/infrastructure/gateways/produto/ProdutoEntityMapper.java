package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.gateways.produto;

import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Categoria;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Produto;
import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.categoria.CategoriaCleanEntity;
import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.produto.ProdutoCleanEntity;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoEntityMapper {

    ProdutoCleanEntity toEntity(Produto produtoDomainObj) {
        return new ProdutoCleanEntity(produtoDomainObj.getNome(),
                produtoDomainObj.getValor().toString(),
                produtoDomainObj.getDescricao(),
                produtoDomainObj.getImagem(),
                produtoDomainObj.getCategoria().getId());
    }

    List<Produto> toDomainObj(List<ProdutoCleanEntity> produtoCleanEntities) {
        List<Produto> produtos = produtoCleanEntities.stream()
                .map(produto -> new Produto(produto.getId(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getImagem(),
                        new BigDecimal(produto.getValor()),
                        new Categoria(produto.getCategoria().getId(), produto.getCategoria().getNome())))
                .toList();

        return produtos;
    }

    Produto toDomainObj(ProdutoCleanEntity produtoCleanEntity) {
        return new Produto(produtoCleanEntity.getId(),
                produtoCleanEntity.getNome(),
                produtoCleanEntity.getDescricao(),
                produtoCleanEntity.getImagem(),
                new BigDecimal(produtoCleanEntity.getValor()),
                new Categoria(produtoCleanEntity.getCategoria().getId(), produtoCleanEntity.getCategoria().getNome()));
    }
}
