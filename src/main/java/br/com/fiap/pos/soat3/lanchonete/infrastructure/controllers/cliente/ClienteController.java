package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.cliente.BuscaClientePorCPFInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.cliente.CadastraClienteInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final CadastraClienteInteractor cadastraClienteUseCase;
    private final BuscaClientePorCPFInteractor buscaClientePorCPFUseCase;
    private final ClienteDTOMapper clienteDTOMapper;

    public ClienteController(CadastraClienteInteractor cadastraClienteUseCase, BuscaClientePorCPFInteractor buscaClientePorCPFUseCase, ClienteDTOMapper clienteDTOMapper) {
        this.cadastraClienteUseCase = cadastraClienteUseCase;
        this.buscaClientePorCPFUseCase = buscaClientePorCPFUseCase;
        this.clienteDTOMapper = clienteDTOMapper;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastraCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente clienteObj = clienteDTOMapper.toCliente(clienteRequest);
        Cliente cliente = cadastraClienteUseCase.cadastraCliente(clienteObj);
        return ResponseEntity.ok(clienteDTOMapper.toResponse(cliente));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscaPorCpf(@PathVariable String cpf) {
        Cliente cliente = buscaClientePorCPFUseCase.bucaClientePorCPF(cpf);
        return ResponseEntity.ok(clienteDTOMapper.toResponse(cliente));
    }
}
