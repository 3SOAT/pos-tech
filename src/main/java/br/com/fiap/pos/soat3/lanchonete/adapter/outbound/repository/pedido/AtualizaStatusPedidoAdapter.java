package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.mapper.PedidoMapper;
import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pedido;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.AtualizaStatusPedidoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;

public class AtualizaStatusPedidoAdapter implements AtualizaStatusPedidoAdapterPort {

    private final PedidoRepository repository;
    private final PedidoMapper pedidoMapper;

    public AtualizaStatusPedidoAdapter(PedidoRepository repository, PedidoMapper pedidoMapper) {
        this.repository = repository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public Pedido atualizaStatusPedido(Long pedidoId, StatusPedido status) {
        try {
          if(repository.existsById(pedidoId)) {
              PedidoEntity pedidoEntity = repository.getReferenceById(pedidoId);
              pedidoEntity.setStatus(status);
              repository.save(pedidoEntity);
              return pedidoMapper.fromEntity(pedidoEntity);
          } else {
              throw new EntityNotFoundException("Pedido não existe", pedidoId.toString());
          }
        } catch (Exception e) {
            throw new EntityNotFoundException("Erro ao atualizar status pedido", pedidoId.toString());
        }
    }
}
