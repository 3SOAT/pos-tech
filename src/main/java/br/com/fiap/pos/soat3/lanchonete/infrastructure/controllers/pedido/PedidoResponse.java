package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.StatusPedido;

import java.util.List;

public class PedidoResponse {

    private Long id;

    private Long clienteId;

    private List<ItemPedido> itensPedido;

    private String totalPedido;

    private StatusPedido status;

    public PedidoResponse(Long id, Long clienteId, List<ItemPedido> itensPedido, String totalPedido,
                          StatusPedido status) {
        this.id = id;
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
        this.totalPedido = totalPedido;
        this.status = status;
    }

//    public static PedidoResponse fromDomain(Pedido pedido) {
//        return new PedidoResponse(pedido.getId(), pedido.getClienteId(), pedido.getItensPedido(),
//                pedido.getTotalPedido(), pedido.getStatus());
//    }

//    public static List<PedidoResponse> fromDomain(List<Pedido> pedidos) {
//        var lista = new ArrayList<PedidoResponse>();
//
//        pedidos.forEach(pedido ->
//                lista.add(
//                        new PedidoResponse(
//                                pedido.getId(),
//                                pedido.getClienteId(),
//                                pedido.getItensPedido(),
//                                pedido.getTotalPedido(),
//                                pedido.getStatus()
//                        )
//                )
//        );
//
//        return lista;
//    }

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

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
