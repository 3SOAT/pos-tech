package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.BuscaPorCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.CriaProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
  private final BuscaPorCategoriaInteractor buscaPorCategoriaUseCase;
  private final CriaProdutoInteractor criaProdutoCleanUseCase;
  private final ProdutoDTOMapper produtoDTOMapper;

  public ProdutoController(BuscaPorCategoriaInteractor buscaPorCategoriaUseCase,
                           CriaProdutoInteractor criaProdutoCleanUseCase,
                           ProdutoDTOMapper produtoDTOMapper) {
    this.buscaPorCategoriaUseCase = buscaPorCategoriaUseCase;
    this.criaProdutoCleanUseCase = criaProdutoCleanUseCase;
    this.produtoDTOMapper = produtoDTOMapper;
  }

  @PostMapping
  public ProdutoResponse criaProduto(@Valid @RequestBody CriaProdutoRequest criaProdutoRequest) {
    Produto produtoBussinessObj = produtoDTOMapper.toProduto(criaProdutoRequest);
    Produto produto = criaProdutoCleanUseCase.criaProduto(produtoBussinessObj);
    return produtoDTOMapper.toResponse(produto);
  }
  @GetMapping("/categoria/{id}")
  public BuscaPorCategoriaResponse buscaPorCategoria(@PathVariable Long id) {
    List<Produto> produtos = buscaPorCategoriaUseCase.buscaPorCategoria(id);
    return produtoDTOMapper.toResponse(produtos);
  }
}
