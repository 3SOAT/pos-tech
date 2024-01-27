package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.mapper.PedidoMapper;
import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.ListaPedidosAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

import java.util.List;
import java.util.stream.Collectors;

public class ListaPedidosAdapter implements ListaPedidosAdapterPort {

    private final PedidoRepository repository;
    private final PedidoMapper pedidoMapper;

    public ListaPedidosAdapter(PedidoRepository repository, PedidoMapper pedidoMapper) {
        this.repository = repository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public List<Pedido> listaPedidos() {
        try {
            var pedidosEntity = repository.findByStatusNot(StatusPedido.FINALIZADO.getStatus());
            return pedidosEntity
                    .stream()
                    .map(pedidoMapper::fromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new EntityNotFoundException("Pedido", "");
        }
    }
}
