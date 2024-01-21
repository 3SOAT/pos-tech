package br.com.fiap.pos.soat3.lanchonete.clean.application.usecases;

import br.com.fiap.pos.soat3.lanchonete.clean.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Produto;

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