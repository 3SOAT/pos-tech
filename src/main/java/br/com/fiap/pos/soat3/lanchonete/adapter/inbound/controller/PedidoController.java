package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller;


import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response.PedidoResponse;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.AtualizaStatusPedidoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.ListaPedidosUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.StatusPedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final ListaPedidosUseCasePort listaPedidosUseCasePort;
    private final AtualizaStatusPedidoUseCasePort atualizaStatusPedidoUseCasePort;

    public PedidoController(
            ListaPedidosUseCasePort listaPedidosUseCasePort,
            AtualizaStatusPedidoUseCasePort atualizaStatusPedidoUseCasePort
    ) {
        this.listaPedidosUseCasePort = listaPedidosUseCasePort;
        this.atualizaStatusPedidoUseCasePort = atualizaStatusPedidoUseCasePort;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PedidoResponse>> listaPedidos() {
        return ResponseEntity.ok(PedidoResponse.fromDomain(listaPedidosUseCasePort.execute()));
    }

    @PutMapping("/status/update")
    public ResponseEntity<PedidoResponse> atualizaStatusPedido(Long pedidoId, StatusPedido statusPedido) {
        return ResponseEntity.ok(PedidoResponse.fromDomain(atualizaStatusPedidoUseCasePort.execute(pedidoId, statusPedido)));
    }
}
