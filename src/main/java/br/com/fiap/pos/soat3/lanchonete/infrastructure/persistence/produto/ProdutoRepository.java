package br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoriaId(Long id);

}