package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    List<PedidoEntity> findByStatusNot(String status);
}
