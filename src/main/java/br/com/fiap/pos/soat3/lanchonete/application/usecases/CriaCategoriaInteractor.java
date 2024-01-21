package br.com.fiap.pos.soat3.lanchonete.application.usecases;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;

public class CriaCategoriaInteractor {
  private final CategoriaGateway categoriaGateway;

  public CriaCategoriaInteractor(CategoriaGateway categoriaGateway) {
    this.categoriaGateway = categoriaGateway;
  }

  public Categoria criaCategoria(Categoria categoria) {
    return categoriaGateway.criaCategoria(categoria);
  }
}
