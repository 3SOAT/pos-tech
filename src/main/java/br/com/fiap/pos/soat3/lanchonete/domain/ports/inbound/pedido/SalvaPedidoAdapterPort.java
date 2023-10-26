package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;

public interface SalvaPedidoAdapterPort {
    
    Pedido salvaPedido(Pedido pedido);
}
