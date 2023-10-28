package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutosPorCategoriaResponse {

    private Integer totalDeItens;
    private List<ProdutoResponse> itens;


    public ProdutosPorCategoriaResponse(List<Produto> produtos) {
        this.totalDeItens = produtos.size();
        this.itens = produtos
                .stream()
                .map(produto -> (ProdutoResponse) ProdutoResponse.fromDomain(produto))
                .collect(Collectors.toList());
        ;
    }


    public static ProdutosPorCategoriaResponse fromDomain(List<Produto> produtos) {
        return new ProdutosPorCategoriaResponse(produtos);
    }

    public Integer getTotalDeItens() {
        return totalDeItens;
    }

    public void setTotalDeItens(Integer id) {
        this.totalDeItens = totalDeItens;
    }

    public List<ProdutoResponse> getItens() {
        return itens;
    }

    public void setItens(String nome) {
        this.itens = itens;
    }

}
