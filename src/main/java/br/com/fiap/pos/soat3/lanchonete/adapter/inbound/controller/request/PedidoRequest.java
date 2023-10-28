package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.request;

public class PedidoRequest {

    private Long produtoId;

    private int quantidade;

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
