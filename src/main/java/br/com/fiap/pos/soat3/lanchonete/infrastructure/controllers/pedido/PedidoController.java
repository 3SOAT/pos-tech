package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;


import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.ConsultaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.ListaPedidosInteractor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.StatusPedido;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final ListaPedidosInteractor listaPedidosUseCase;
    private final AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase;
    private final ConsultaStatusPedidoInteractor consultaStatusPedidoUseCase;
    private final PedidoDTOMapper pedidoDTOMapper;

    public PedidoController(ListaPedidosInteractor listaPedidosUseCase, AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase, ConsultaStatusPedidoInteractor consultaStatusPedidoUseCase, PedidoDTOMapper pedidoDTOMapper) {
        this.listaPedidosUseCase = listaPedidosUseCase;
        this.atualizaStatusPedidoUseCase = atualizaStatusPedidoUseCase;
        this.consultaStatusPedidoUseCase = consultaStatusPedidoUseCase;
        this.pedidoDTOMapper = pedidoDTOMapper;
    }


    @GetMapping("/lista")
    public ResponseEntity<List<PedidoResponse>> listaPedidos() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/status")
    public ResponseEntity<StatusPedido> consultaStatusPedido(Long pedidoId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/status/update")
    public ResponseEntity<PedidoResponse> atualizaStatusPedido(Long pedidoId, StatusPedido statusPedido) {
        return ResponseEntity.ok().build();
    }
}
