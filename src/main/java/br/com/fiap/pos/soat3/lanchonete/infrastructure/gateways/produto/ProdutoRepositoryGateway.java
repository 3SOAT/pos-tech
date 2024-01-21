package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto.ProdutoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto.ProdutoRepository;

import java.util.List;

public class ProdutoRepositoryGateway implements ProdutoGateway {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    public ProdutoRepositoryGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoEntityMapper = produtoEntityMapper;
    }

    @Override
    public List<Produto> buscaPorCategoria(Long id) {
        List<ProdutoEntity> produtoEntities = produtoRepository.findByCategoriaId(id);
        return produtoEntityMapper.toDomainObj(produtoEntities);
    }

    @Override
    public Produto criaProduto(Produto produto) {
        ProdutoEntity produtoEntity = produtoEntityMapper.toEntity(produto);
        ProdutoEntity produtoCleanEntity = produtoRepository.save(produtoEntity);
        return produtoEntityMapper.toDomainObj(produtoCleanEntity);
    }
}
