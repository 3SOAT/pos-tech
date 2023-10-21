package br.com.fiap.pos.soat3.lanchonete.domain.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    
    private Long id;
    
    private Cliente Cliente;
    
    private List<Produto> produtos;
    
    private LocalDateTime dataDeCriacao;
    
    private BigDecimal totalPedido;

    public Pedido(Long id, Cliente cliente, List<Produto> produtos, LocalDateTime dataDeCriacao, BigDecimal totalPedido) {
        this.id = id;
        Cliente = cliente;
        this.produtos = produtos;
        this.dataDeCriacao = dataDeCriacao;
        this.totalPedido = totalPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }
}
