package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.gateways.produto;

import br.com.fiap.pos.soat3.lanchonete.clean.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Produto;
import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.categoria.CategoriaCleanEntity;
import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.produto.ProdutoCleanEntity;
import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.produto.ProdutoCleanRepository;

import java.util.List;

public class ProdutoRepositoryGateway implements ProdutoGateway {

    private final ProdutoCleanRepository produtoCleanRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    public ProdutoRepositoryGateway(ProdutoCleanRepository produtoCleanRepository, ProdutoEntityMapper produtoEntityMapper) {
        this.produtoCleanRepository = produtoCleanRepository;
        this.produtoEntityMapper = produtoEntityMapper;
    }

    @Override
    public List<Produto> buscaPorCategoria(Long id) {
        List<ProdutoCleanEntity> produtoEntities = produtoCleanRepository.findByCategoriaId(id);
        return produtoEntityMapper.toDomainObj(produtoEntities);
    }

    @Override
    public Produto criaProduto(Produto produto) {
        ProdutoCleanEntity produtoEntity = produtoEntityMapper.toEntity(produto);
        ProdutoCleanEntity produtoCleanEntity = produtoCleanRepository.save(produtoEntity);
        return produtoEntityMapper.toDomainObj(produtoCleanEntity);
    }
}
