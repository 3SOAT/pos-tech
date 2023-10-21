package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PedidoResponse {

    @NotNull
    private Long id;

    private Cliente Cliente;

    @Size(min=1)
    private List<Produto> produtos;

    public PedidoResponse(@NotNull Long id, Cliente cliente, List<Produto> produtos) {
        this.id = id;
        Cliente = cliente;
        this.produtos = produtos;
    }

    public static PedidoResponse fromDomain(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getCliente(), pedido.getProduto());
        
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
}
