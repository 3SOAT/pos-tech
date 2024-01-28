package br.com.fiap.pos.soat3.lanchonete.config.exception;

public class GenericException extends RuntimeException {

    public GenericException(String detail) {
        super(String.format("%s", detail));
    }
}
