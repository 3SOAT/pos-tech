package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto;

public record CriaProdutoRequest(String nome, String descricao, String imagem, String valor, Long categoriaId) {
}
