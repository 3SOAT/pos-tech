package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    ClienteEntity findByCpf(String cpf);
}
