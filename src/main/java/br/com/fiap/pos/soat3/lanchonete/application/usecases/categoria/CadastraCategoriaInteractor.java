package br.com.fiap.pos.soat3.lanchonete.application.usecases.categoria;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;

public class CadastraCategoriaInteractor {
    private final CategoriaGateway categoriaGateway;

    public CadastraCategoriaInteractor(CategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway;
    }

    public Categoria cadastraCategoria(Categoria categoria) {
        return categoriaGateway.cadastraCategoria(categoria);
    }
}
