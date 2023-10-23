package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller;

import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.request.ClienteRequest;
import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response.ClienteResponse;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.cliente.BuscaClientePorCPFUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.cliente.CadastraClienteUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CadastraClienteUseCasePort cadastraClienteUseCasePort;

    private final BuscaClientePorCPFUseCasePort buscaClientePorCPFUseCasePort;

    public ClienteController(CadastraClienteUseCasePort cadastraClienteUseCasePort, BuscaClientePorCPFUseCasePort buscaClientePorCPFUseCasePort) {
        this.cadastraClienteUseCasePort = cadastraClienteUseCasePort;
        this.buscaClientePorCPFUseCasePort = buscaClientePorCPFUseCasePort;
    }
    
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastraCliente(@Valid @RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.ok(ClienteResponse.fromDomain(cadastraClienteUseCasePort.execute(clienteRequest.toClienteDomain())));
    }
    
    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscaPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(ClienteResponse.fromDomain(buscaClientePorCPFUseCasePort.execute(cpf)));
    }
}
