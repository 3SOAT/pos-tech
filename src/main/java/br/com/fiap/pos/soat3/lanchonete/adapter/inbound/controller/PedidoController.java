package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller;


import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response.PedidoResponse;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.ListaPedidosUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final ListaPedidosUseCasePort listaPedidosUseCasePort;

    public PedidoController(ListaPedidosUseCasePort listaPedidosUseCasePort) {
        this.listaPedidosUseCasePort = listaPedidosUseCasePort;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PedidoResponse>> listaPedidos() {
        return ResponseEntity.ok(PedidoResponse.fromDomain(listaPedidosUseCasePort.execute()));
    }
}
