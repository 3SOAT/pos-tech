package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.gateways.categoria;

import br.com.fiap.pos.soat3.lanchonete.clean.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Categoria;
import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.categoria.CategoriaCleanEntity;
import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.categoria.CategoriaCleanRepository;

public class CategoriaRepositoryGateway implements CategoriaGateway {
  private final CategoriaCleanRepository categoriaCleanRepository;
  private final CategoriaEntityMapper categoriaEntityMapper;

  public CategoriaRepositoryGateway(CategoriaCleanRepository categoriaCleanRepository, CategoriaEntityMapper categoriaEntityMapper) {
    this.categoriaCleanRepository = categoriaCleanRepository;
    this.categoriaEntityMapper = categoriaEntityMapper;
  }

  @Override
  public Categoria criaCategoria(Categoria categoria) {
    CategoriaCleanEntity categoriaEntity = categoriaEntityMapper.toEntity(categoria);
    CategoriaCleanEntity savedEntity = categoriaCleanRepository.save(categoriaEntity);
    return categoriaEntityMapper.toDomainObj(savedEntity);
  }
}
