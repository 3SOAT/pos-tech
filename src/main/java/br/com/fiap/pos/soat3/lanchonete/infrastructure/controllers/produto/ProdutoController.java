package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.AlteraProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.BuscaPorCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.CriaProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
  private final BuscaPorCategoriaInteractor buscaPorCategoriaUseCase;
  private final CriaProdutoInteractor criaProdutoUseCase;

  private final AlteraProdutoInteractor alteraProdutoUseCase;
  private final ProdutoDTOMapper produtoDTOMapper;

  public ProdutoController(BuscaPorCategoriaInteractor buscaPorCategoriaUseCase,
                           CriaProdutoInteractor criaProdutoUseCase,
                           AlteraProdutoInteractor alteraProdutoUseCase,
                           ProdutoDTOMapper produtoDTOMapper) {
    this.buscaPorCategoriaUseCase = buscaPorCategoriaUseCase;
    this.criaProdutoUseCase = criaProdutoUseCase;
    this.alteraProdutoUseCase = alteraProdutoUseCase;
    this.produtoDTOMapper = produtoDTOMapper;
  }

  @PostMapping
  public ProdutoResponse criaProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
    Produto produtoBussinessObj = produtoDTOMapper.toProduto(produtoRequest);
    Produto produto = criaProdutoUseCase.criaProduto(produtoBussinessObj);
    return produtoDTOMapper.toResponse(produto);
  }

  @PutMapping("/{id}")
  public ProdutoResponse alteraProduto(@PathVariable Long id, @NotEmpty @RequestBody ProdutoRequest produtoRequest) {
    Produto produtoBussinessObj = produtoDTOMapper.toProduto(id, produtoRequest);
    Produto produto = alteraProdutoUseCase.alteraProduto(produtoBussinessObj);
    return produtoDTOMapper.toResponse(produto);
  }

  @GetMapping("/categoria/{id}")
  public BuscaPorCategoriaResponse buscaPorCategoria(@PathVariable Long id) {
    List<Produto> produtos = buscaPorCategoriaUseCase.buscaPorCategoria(id);
    return produtoDTOMapper.toResponse(produtos);
  }
}
