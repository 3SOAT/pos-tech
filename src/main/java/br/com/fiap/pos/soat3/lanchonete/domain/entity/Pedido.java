package br.com.fiap.pos.soat3.lanchonete.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private Long id;

    private Long clienteId;

    private List<ItemPedido> itensPedido;

    private LocalDateTime dataDeCriacao;

    private String totalPedido;

    private StatusPedido status;

    public Pedido() {

    }

    public Pedido(Long clienteId, List<ItemPedido> itensPedido) {
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
    }

    public Pedido(Long id, Long clienteId, List<ItemPedido> itensPedido, LocalDateTime dataDeCriacao, String totalPedido,
                  StatusPedido status) {
        this.id = id;
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
        this.dataDeCriacao = dataDeCriacao;
        this.totalPedido = totalPedido;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
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

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
