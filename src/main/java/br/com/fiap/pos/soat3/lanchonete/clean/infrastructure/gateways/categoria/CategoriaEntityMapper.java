package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.gateways.categoria;

import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Categoria;
import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.categoria.CategoriaCleanEntity;

public class CategoriaEntityMapper {
  CategoriaCleanEntity toEntity(Categoria categoriaDomainObj) {
    return new CategoriaCleanEntity(categoriaDomainObj.getNome());
  }

  Categoria toDomainObj(CategoriaCleanEntity categoriaCleanEntity) {
    return new Categoria(categoriaCleanEntity.getId(), categoriaCleanEntity.getNome());
  }
}
