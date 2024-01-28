package br.com.fiap.pos.soat3.lanchonete.application.usecases.produto;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;

import java.util.List;

public class BuscaPorCategoriaInteractor {
    private final ProdutoGateway produtoGateway;

    public BuscaPorCategoriaInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public List<Produto> buscaPorCategoria(Long id) {
        return produtoGateway.buscaPorCategoria(id);
    }
}
