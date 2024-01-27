package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response.CategoriaResponse;

public record ProdutoResponse(Long id, String nome, String descricao, String imagem, String valor, CategoriaResponse categoria) {
}
