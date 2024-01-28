package br.com.fiap.pos.soat3.lanchonete.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;

public interface CategoriaGateway {
    Categoria cadastraCategoria(Categoria categoria);

    Categoria buscaCategoria(Long id);
}
