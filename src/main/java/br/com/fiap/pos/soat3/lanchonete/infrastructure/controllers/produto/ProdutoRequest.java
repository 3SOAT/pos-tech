package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto;

public record ProdutoRequest(String nome, String descricao, String imagem, String valor, Long categoriaId) {
}
