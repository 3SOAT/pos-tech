package br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido;

import jakarta.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @Column(name = "produto_id")
    private Long produtoId;

    @Column(name = "quantidade")
    private int quantidade;

    public ItemPedidoEntity() {
    }

    public ItemPedidoEntity(Long produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
