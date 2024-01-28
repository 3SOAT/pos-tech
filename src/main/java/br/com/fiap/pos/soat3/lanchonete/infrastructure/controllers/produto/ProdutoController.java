package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.AlteraProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.BuscaPorCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.CadastraProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
  private final BuscaPorCategoriaInteractor buscaPorCategoriaUseCase;
  private final CadastraProdutoInteractor cadastraProdutoUseCase;

  private final AlteraProdutoInteractor alteraProdutoUseCase;
  private final ProdutoDTOMapper produtoDTOMapper;

  public ProdutoController(BuscaPorCategoriaInteractor buscaPorCategoriaUseCase,
                           CadastraProdutoInteractor cadastraProdutoUseCase,
                           AlteraProdutoInteractor alteraProdutoUseCase,
                           ProdutoDTOMapper produtoDTOMapper) {
    this.buscaPorCategoriaUseCase = buscaPorCategoriaUseCase;
    this.cadastraProdutoUseCase = cadastraProdutoUseCase;
    this.alteraProdutoUseCase = alteraProdutoUseCase;
    this.produtoDTOMapper = produtoDTOMapper;
  }

  @PostMapping
  public ProdutoResponse cadastraProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
    Produto produtoBussinessObj = produtoDTOMapper.toProduto(produtoRequest);
    Produto produto = cadastraProdutoUseCase.cadastraProduto(produtoBussinessObj);
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
