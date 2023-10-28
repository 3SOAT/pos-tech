package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.ItemPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "cliente_id")
    private Long clientId;

    @OneToMany(cascade = ALL, mappedBy = "pedido")
    private List<ItemPedidoEntity> itensPedido;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "total_pedido")
    private String totalPedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<ItemPedidoEntity> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoEntity> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(String totalPedido) {
        this.totalPedido = totalPedido;
    }
}
