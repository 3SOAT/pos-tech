package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.request;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class PagamentoRequest {

    private Long clienteId;

    @Size(min=1)
    @NotNull
    private List<PedidoRequest> itensPedido;

    public PagamentoRequest(Long clienteId, List<PedidoRequest> itensPedido) {
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<PedidoRequest> getitensPedido() {
        return itensPedido;
    }

    public void setitensPedido(List<PedidoRequest> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Pagamento toDomain() {
        
        List<ItemPedido> itens = new ArrayList<>();
        for (PedidoRequest item: itensPedido){
            itens.add(new ItemPedido(item.getProdutoId(), item.getQuantidade()));
        }
        return new Pagamento(new Pedido(clienteId, itens));
    }
}
