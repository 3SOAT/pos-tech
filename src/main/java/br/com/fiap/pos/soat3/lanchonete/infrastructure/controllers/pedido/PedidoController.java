package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;


import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.ConsultaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido.ListaPedidosInteractor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.StatusPedido;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final ListaPedidosInteractor listaPedidosInteractor;
    private final AtualizaStatusPedidoInteractor atualizaStatusPedidoInteractor;
    private final ConsultaStatusPedidoInteractor consultaStatusPedidoInteractor;
    private final PedidoDTOMapper pedidoDTOMapper;

    public PedidoController(ListaPedidosInteractor listaPedidosInteractor, AtualizaStatusPedidoInteractor atualizaStatusPedidoInteractor, 
                            ConsultaStatusPedidoInteractor consultaStatusPedidoInteractor, 
                            PedidoDTOMapper pedidoDTOMapper) {
        this.listaPedidosInteractor = listaPedidosInteractor;
        this.atualizaStatusPedidoInteractor = atualizaStatusPedidoInteractor;
        this.consultaStatusPedidoInteractor = consultaStatusPedidoInteractor;
        this.pedidoDTOMapper = pedidoDTOMapper;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PedidoResponse>> listaPedidos() {
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{pedidoId}/status")
    public ResponseEntity<StatusPedido> consultaStatusPedido(@PathVariable("pedidoId") Long pedidoId) {
//        return ResponseEntity.ok(consultaStatusPedidoInteractor.execute(pedidoId));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{pedidoId}/status/{status}")
    public ResponseEntity<PedidoResponse> atualizaStatusPedido(@PathVariable("pedidoId") Long pedidoId,
                                                               @PathVariable("status") StatusPedido statusPedido) {
//        return ResponseEntity.ok(PedidoResponse.fromDomain(atualizaStatusPedidoInteractor.execute(pedidoId, statusPedido)));
        return ResponseEntity.ok().build();
    }
}
