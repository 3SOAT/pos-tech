package br.com.fiap.pos.soat3.lanchonete.clean.application.usecases;

import br.com.fiap.pos.soat3.lanchonete.clean.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Categoria;

public class CriaCategoriaInteractor {
  private final CategoriaGateway categoriaGateway;

  public CriaCategoriaInteractor(CategoriaGateway categoriaGateway) {
    this.categoriaGateway = categoriaGateway;
  }

  public Categoria criaCategoria(Categoria categoria) {
    return categoriaGateway.criaCategoria(categoria);
  }
}
