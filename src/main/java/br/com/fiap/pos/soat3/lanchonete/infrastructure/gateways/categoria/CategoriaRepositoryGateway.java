package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.categoria;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.categoria.CategoriaEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.categoria.CategoriaRepository;

import java.util.Optional;

public class CategoriaRepositoryGateway implements CategoriaGateway {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;

    public CategoriaRepositoryGateway(CategoriaRepository categoriaRepository, CategoriaEntityMapper categoriaEntityMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaEntityMapper = categoriaEntityMapper;
    }

    @Override
    public Categoria cadastraCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = categoriaEntityMapper.toEntity(categoria);
        CategoriaEntity savedEntity = categoriaRepository.save(categoriaEntity);
        return categoriaEntityMapper.toDomainObj(savedEntity);
    }

    @Override
    public Categoria buscaCategoria(Long id) {
        Optional<CategoriaEntity> savedEntity = categoriaRepository.findById(id);
        if (savedEntity.isPresent()) {
            return categoriaEntityMapper.toDomainObj(savedEntity.get());
        } else {
            throw new EntityNotFoundException("Categoria", id.toString());
        }
    }
}
