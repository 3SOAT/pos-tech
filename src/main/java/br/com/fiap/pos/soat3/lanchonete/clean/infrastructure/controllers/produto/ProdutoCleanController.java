package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.clean.application.usecases.BuscaPorCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.clean.application.usecases.CriaProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Produto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtoclean")
public class ProdutoCleanController {
  private final BuscaPorCategoriaInteractor buscaPorCategoriaUseCase;
  private final CriaProdutoInteractor criaProdutoCleanUseCase;
  private final ProdutoDTOMapper produtoDTOMapper;

  public ProdutoCleanController(BuscaPorCategoriaInteractor buscaPorCategoriaUseCase,
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
  @GetMapping("/categoria/{categoriaId}")
  public BuscaPorCategoriaResponse buscaPorCategoria(@RequestBody Long id) {
    List<Produto> produtos = buscaPorCategoriaUseCase.buscaPorCategoria(id);
    return produtoDTOMapper.toResponse(produtos);
  }
}
