package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.controllers.produto;

import java.util.List;

public record BuscaPorCategoriaResponse(Integer totalDeItens, List<ProdutoResponse> produtos){

}
