package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller;

import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.request.ProdutoRequest;
import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response.ProdutoResponse;
import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response.ProdutosPorCategoriaResponse;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.RecuperaProdutoPorCategoriaUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.AtualizaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.CriaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.DeletaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.RecuperaProdutoUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    private final CriaProdutoUseCasePort criaProdutoUseCasePort;
    
    private final RecuperaProdutoUseCasePort recuperaProdutoUseCasePort;
    
    private final AtualizaProdutoUseCasePort atualizaProdutoUseCasePort;
    
    private final DeletaProdutoUseCasePort deletaProdutoUseCasePort;

    private final RecuperaProdutoPorCategoriaUseCasePort recuperaProdutoPorCategoriaUseCasePort;

    public ProdutoController(CriaProdutoUseCasePort criaProdutoUseCasePort, RecuperaProdutoUseCasePort recuperaProdutoUseCasePort, AtualizaProdutoUseCasePort atualizaProdutoUseCasePort, DeletaProdutoUseCasePort deletaProdutoUseCasePort, RecuperaProdutoPorCategoriaUseCasePort recuperaProdutoPorCategoriaUseCasePort) {
        this.criaProdutoUseCasePort = criaProdutoUseCasePort;
        this.recuperaProdutoUseCasePort = recuperaProdutoUseCasePort;
        this.atualizaProdutoUseCasePort = atualizaProdutoUseCasePort;
        this.deletaProdutoUseCasePort = deletaProdutoUseCasePort;
        this.recuperaProdutoPorCategoriaUseCasePort = recuperaProdutoPorCategoriaUseCasePort;
    }
    
    @PostMapping
    public ResponseEntity<ProdutoResponse> criaProduto(@Valid @RequestBody ProdutoRequest produtoRequest){
        return ResponseEntity.ok(ProdutoResponse.fromDomain(criaProdutoUseCasePort.execute(produtoRequest.toDomain())));
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponse> atualizaProduto(@PathVariable Long produtoId, @Valid @RequestBody ProdutoRequest produtoRequest){
        return ResponseEntity.ok(ProdutoResponse.fromDomain(atualizaProdutoUseCasePort.execute(produtoRequest.toDomain(produtoId))));
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> atualizaProduto(@PathVariable Long produtoId){
        deletaProdutoUseCasePort.execute(produtoId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponse> recuperaProdutoPorId(@PathVariable Long produtoId){
        return ResponseEntity.ok(ProdutoResponse.fromDomain(recuperaProdutoUseCasePort.execute(produtoId)));
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<ProdutosPorCategoriaResponse> recuperaProdutosPorCategoriaId(@PathVariable Long categoriaId){
        return ResponseEntity.ok(ProdutosPorCategoriaResponse.fromDomain(recuperaProdutoPorCategoriaUseCasePort.execute(categoriaId)));
    }
}
