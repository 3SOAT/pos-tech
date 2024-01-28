package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;

public class ClienteDTOMapper {

    public ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCPF());
    }

    public Cliente toCliente(ClienteRequest request) {
        return new Cliente(request.nome(), request.email(), request.CPF());
    }
}
