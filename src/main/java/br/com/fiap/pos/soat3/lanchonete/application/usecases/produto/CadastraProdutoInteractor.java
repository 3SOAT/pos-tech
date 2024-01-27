package br.com.fiap.pos.soat3.lanchonete.application.usecases.produto;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;

public class CadastraProdutoInteractor {
    private final ProdutoGateway produtoGateway;


    public CadastraProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto cadastraProduto(Produto produto) {
        return produtoGateway.cadastraProduto(produto);
    }
}
