package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;


import java.util.List;

public class PedidoResponse {
    
    private Long id;

    private Long clienteId;
    
    private List<ItemPedido> itensPedido;
    
    private String totalPedido;

    public PedidoResponse(Long id, Long clienteId, List<ItemPedido> itensPedido, String totalPedido) {
        this.id = id;
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
        this.totalPedido = totalPedido;
    }

    public static PedidoResponse fromDomain(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getClienteId(), pedido.getItensPedido(),
                pedido.getTotalPedido());
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

    public String getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(String totalPedido) {
        this.totalPedido = totalPedido;
    }
}
