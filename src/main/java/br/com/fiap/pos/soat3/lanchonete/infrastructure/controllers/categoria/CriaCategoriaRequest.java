package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria;

import jakarta.validation.constraints.NotEmpty;

public record CriaCategoriaRequest(@NotEmpty(message = "Name cannot be empty") String nome) {
}
