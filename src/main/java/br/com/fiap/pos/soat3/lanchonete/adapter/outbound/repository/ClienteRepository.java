package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    void cadastraCliente();

    ClienteEntity buscaPorCpf(String cpf);
}
