package br.com.fiap.pos.soat3.lanchonete.domain.domain;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.ItemPedidoEntity;

import java.util.ArrayList;
import java.util.List;

public class ItemPedido {

    private Long produtoId;

    private int quantidade;

    public ItemPedido(Long produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
