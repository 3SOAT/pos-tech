package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido;

import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.ConsultaStatusPedidoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

public class ConsultarStatusPedidoAdapter implements ConsultaStatusPedidoAdapterPort {

    private final PedidoRepository repository;

    public ConsultarStatusPedidoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public StatusPedido consultaStatusPedido(Long pedidoId) {
        if (repository.existsById(pedidoId)) {
            return repository.getReferenceById(pedidoId).getStatus();
        } else {
            throw new EntityNotFoundException("Pedido não existe", pedidoId.toString());
        }
    }
}
