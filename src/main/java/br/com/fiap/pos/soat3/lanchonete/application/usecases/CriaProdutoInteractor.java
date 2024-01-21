package br.com.fiap.pos.soat3.lanchonete.application.usecases;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;

public class CriaProdutoInteractor {
    private final ProdutoGateway produtoGateway;

    public CriaProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto criaProduto(Produto produto) {
        return produtoGateway.criaProduto(produto);
    }
}
