package br.com.fiap.pos.soat3.lanchonete.config.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entityName, Long id) {
        super(String.format("%s with id %d not found.", entityName, id));
    }
}
