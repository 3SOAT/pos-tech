package br.com.fiap.pos.soat3.lanchonete.infrastructure.config.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityName, String id) {
        super(String.format("%s com este identificador [%s] não foi encontrado.", entityName, id));
    }
}
