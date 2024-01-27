package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.produto;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoCleanRepository extends CrudRepository<ProdutoCleanEntity, Long> {

    List<ProdutoCleanEntity> findByCategoriaId(Long id);

}