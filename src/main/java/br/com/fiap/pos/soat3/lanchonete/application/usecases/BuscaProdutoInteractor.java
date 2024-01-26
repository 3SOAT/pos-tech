package br.com.fiap.pos.soat3.lanchonete.application.usecases;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;

import java.util.List;

public class BuscaProdutoInteractor {
    private final ProdutoGateway produtoGateway;

    public BuscaProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }
    public Produto buscaProduto(Long id) {
        return produtoGateway.buscaProduto(id);
    }
}
