package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto.mapper;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto.ProdutoEntity;
import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto.ProdutoRepository;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProdutoMapper {
    private final ProdutoRepository produtoRepository;

    public ProdutoMapper(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity getEntityFromDomain(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(produto.getId());
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setImagem(produto.getImagem());
        produtoEntity.setValor(String.valueOf(produto.getValor()));
        produtoEntity.setCategoriaId(produto.getCategoria().getId());
        return produtoEntity;
    }

    public Produto fromEntity(ProdutoEntity produtoEntity) {
        return new Produto(produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getImagem(),
                new BigDecimal(produtoEntity.getValor()),
                new Categoria(produtoEntity.getCategoriaId()));
    }
}
