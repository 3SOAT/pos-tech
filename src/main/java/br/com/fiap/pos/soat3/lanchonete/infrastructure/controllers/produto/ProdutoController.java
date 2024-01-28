package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.AlteraProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.BuscaPorCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.BuscaProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.CadastraProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.DeletaProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final BuscaPorCategoriaInteractor buscaPorCategoriaUseCase;
    private final CadastraProdutoInteractor cadastraProdutoUseCase;
    private final AlteraProdutoInteractor alteraProdutoUseCase;
    private final DeletaProdutoInteractor deletaProdutoUseCase;
    private final BuscaProdutoInteractor buscaProdutoUseCase;
    private final ProdutoDTOMapper produtoDTOMapper;

    public ProdutoController(BuscaPorCategoriaInteractor buscaPorCategoriaUseCase,
                             CadastraProdutoInteractor cadastraProdutoUseCase,
                             AlteraProdutoInteractor alteraProdutoUseCase,
                             DeletaProdutoInteractor deletaProdutoUseCase,
                             BuscaProdutoInteractor buscaProdutoUseCase,
                             ProdutoDTOMapper produtoDTOMapper) {
        this.buscaPorCategoriaUseCase = buscaPorCategoriaUseCase;
        this.cadastraProdutoUseCase = cadastraProdutoUseCase;
        this.alteraProdutoUseCase = alteraProdutoUseCase;
        this.deletaProdutoUseCase = deletaProdutoUseCase;
        this.buscaProdutoUseCase = buscaProdutoUseCase;
        this.produtoDTOMapper = produtoDTOMapper;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastraProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
        Produto produtoBussinessObj = produtoDTOMapper.toProduto(produtoRequest);
        Produto produto = cadastraProdutoUseCase.cadastraProduto(produtoBussinessObj);
        return ResponseEntity.ok(produtoDTOMapper.toResponse(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> alteraProduto(@PathVariable Long id, @NotEmpty @RequestBody ProdutoRequest produtoRequest) {
        Produto produtoBussinessObj = produtoDTOMapper.toProduto(id, produtoRequest);
        Produto produto = alteraProdutoUseCase.alteraProduto(produtoBussinessObj);
        return ResponseEntity.ok(produtoDTOMapper.toResponse(produto));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<BuscaPorCategoriaResponse> buscaPorCategoria(@PathVariable Long id) {
        List<Produto> produtos = buscaPorCategoriaUseCase.buscaPorCategoria(id);
        return ResponseEntity.ok(produtoDTOMapper.toResponse(produtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable Long id) {
        deletaProdutoUseCase.deletaProduto(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> recuperaProdutoPorId(@PathVariable Long id) {
        Produto produto = buscaProdutoUseCase.buscaProduto(id);
        return ResponseEntity.ok(produtoDTOMapper.toResponse(produto));
    }
}
