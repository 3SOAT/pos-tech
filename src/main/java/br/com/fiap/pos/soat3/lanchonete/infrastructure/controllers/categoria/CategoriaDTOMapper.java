package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;

public class CategoriaDTOMapper {

    CategoriaResponse toResponse(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }

    public Categoria toCategoria(CategoriaRequest request) {
        return new Categoria(request.nome());
    }
}
