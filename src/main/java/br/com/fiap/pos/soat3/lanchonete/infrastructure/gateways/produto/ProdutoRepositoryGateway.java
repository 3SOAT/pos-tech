package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto.ProdutoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto.ProdutoRepository;

import java.util.List;
import java.util.Optional;

public class ProdutoRepositoryGateway implements ProdutoGateway {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    private final CategoriaGateway categoriaGateway;

    public ProdutoRepositoryGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper, CategoriaGateway categoriaGateway) {
        this.produtoRepository = produtoRepository;
        this.produtoEntityMapper = produtoEntityMapper;
        this.categoriaGateway = categoriaGateway;
    }

    @Override
    public List<Produto> buscaPorCategoria(Long id) {
        List<ProdutoEntity> produtoEntities = produtoRepository.findByCategoriaId(id);
        return produtoEntityMapper.toDomainObj(produtoEntities);
    }

    @Override
    public Produto buscaProduto(Long id) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
        if (produtoEntity.isPresent()) {
            return produtoEntityMapper.toDomainObj(produtoEntity.get());
        } else {
            throw new EntityNotFoundException("Produto não existe", id.toString());
        }
    }

    @Override
    public Produto cadastraProduto(Produto produto) {
        produto.setCategoria(categoriaGateway.buscaCategoria(produto.getCategoria().getId()));
        ProdutoEntity produtoEntity = produtoEntityMapper.toEntity(produto);
        ProdutoEntity produtoSalvoEntity = produtoRepository.save(produtoEntity);
        return produtoEntityMapper.toDomainObj(produtoSalvoEntity);
    }

    @Override
    public Produto alteraProduto(Produto produto) {
        Optional<ProdutoEntity> produtoAlterar = produtoRepository.findById(produto.getId());
        if (produtoAlterar.isPresent()) {
            ProdutoEntity produtoEntity = produtoEntityMapper.updateEntity(produtoAlterar.get(), produto);
            ProdutoEntity produtoSalvoEntity = produtoRepository.save(produtoEntity);
            return produtoEntityMapper.toDomainObj(produtoSalvoEntity);
        } else {
            throw new EntityNotFoundException("Produto não existe", produto.getId().toString());
        }
    }

    @Override
    public void deletaProduto(Long id) {
        Optional<ProdutoEntity> produtoDeletar = produtoRepository.findById(id);
        if (produtoDeletar.isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Produto não existe", id.toString());
        }
    }
}
