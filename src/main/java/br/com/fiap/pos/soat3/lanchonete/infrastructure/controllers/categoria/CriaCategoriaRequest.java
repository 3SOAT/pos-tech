package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria;

import jakarta.validation.constraints.NotEmpty;

public record CriaCategoriaRequest(@NotEmpty(message = "Nome da Categoria não pode ser vazio") String nome) {
}
