package br.com.fiap.pos.soat3.lanchonete.clean.application.gateways;

import br.com.fiap.pos.soat3.lanchonete.clean.domain.entity.Categoria;

import java.util.List;

public interface CategoriaGateway {
  Categoria criaCategoria(Categoria categoria);
}
