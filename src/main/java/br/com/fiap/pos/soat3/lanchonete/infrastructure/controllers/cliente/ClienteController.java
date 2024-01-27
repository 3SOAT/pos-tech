package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.BuscaClientePorCPFInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.CriaClienteInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final CriaClienteInteractor criaClienteUseCase;
    private final BuscaClientePorCPFInteractor buscaClientePorCPFUseCase;
    private final ClienteDTOMapper clienteDTOMapper;

    public ClienteController(CriaClienteInteractor criaClienteUseCase, BuscaClientePorCPFInteractor buscaClientePorCPFUseCase, ClienteDTOMapper clienteDTOMapper) {
        this.criaClienteUseCase = criaClienteUseCase;
        this.buscaClientePorCPFUseCase = buscaClientePorCPFUseCase;
        this.clienteDTOMapper = clienteDTOMapper;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> criaCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente clienteObj = clienteDTOMapper.toCliente(clienteRequest);
        Cliente cliente = criaClienteUseCase.criaCliente(clienteObj);
        return ResponseEntity.ok(clienteDTOMapper.toResponse(cliente));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscaPorCpf(@PathVariable String cpf) {
        Cliente cliente = buscaClientePorCPFUseCase.bucaClientePorCPF(cpf);
        return ResponseEntity.ok(clienteDTOMapper.toResponse(cliente));
    }
}
