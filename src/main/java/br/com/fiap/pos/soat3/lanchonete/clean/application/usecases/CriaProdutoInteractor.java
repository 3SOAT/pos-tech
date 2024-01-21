package br.com.fiap.pos.soat3.lanchonete.clean.application.usecases;

import br.com.fiap.pos.soat3.lanchonete.clean.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Produto;

public class CriaProdutoInteractor {
    private final ProdutoGateway produtoGateway;

    public CriaProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto criaProduto(Produto produto) {
        return produtoGateway.criaProduto(produto);
    }
}
