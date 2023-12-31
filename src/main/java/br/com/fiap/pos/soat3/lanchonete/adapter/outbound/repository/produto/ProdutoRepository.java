package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoriaId(Long id);

    Optional<ProdutoEntity> findById(Long id);
}
