package br.com.fiap.pos.soat3.lanchonete.application.usecases.produto;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;

public class DeletaProdutoInteractor {
    private final ProdutoGateway produtoGateway;

    public DeletaProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public void deletaProduto(Long id) {
        produtoGateway.deletaProduto(id);
    }
}
