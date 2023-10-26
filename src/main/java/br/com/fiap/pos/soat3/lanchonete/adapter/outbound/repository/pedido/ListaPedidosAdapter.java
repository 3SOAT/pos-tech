package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido;

import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.ListaPedidosAdapterPort;

import java.util.List;
import java.util.stream.Collectors;

public class ListaPedidosAdapter implements ListaPedidosAdapterPort {

    private final PedidoRepository repository;

    public ListaPedidosAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> listaPedidos() {
        try {
            var pedidosEntity = repository.findAll();
            return pedidosEntity
                    .stream()
                    .map(pedido -> (Pedido) Pedido.fromEntity(pedido))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new EntityNotFoundException("Pedido", "");
        }
    }
}
