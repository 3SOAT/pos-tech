package br.com.fiap.pos.soat3.lanchonete.application.usecases.produto;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;
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
