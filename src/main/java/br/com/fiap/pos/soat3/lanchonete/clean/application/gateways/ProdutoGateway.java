package br.com.fiap.pos.soat3.lanchonete.clean.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Produto;

import java.util.List;

public interface ProdutoGateway {
    List<Produto> buscaPorCategoria(Long id);

    Produto criaProduto(Produto produto);
}
