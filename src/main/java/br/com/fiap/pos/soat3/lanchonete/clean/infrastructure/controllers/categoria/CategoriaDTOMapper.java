package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.controllers.categoria;

import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Categoria;

public class CategoriaDTOMapper {

    CriaCategoriaResponse toResponse(Categoria categoria) {
        return new CriaCategoriaResponse(categoria.getId(), categoria.getNome());
    }

    public Categoria toCategoria(CriaCategoriaRequest request) {
        return new Categoria(request.nome());
    }
}
