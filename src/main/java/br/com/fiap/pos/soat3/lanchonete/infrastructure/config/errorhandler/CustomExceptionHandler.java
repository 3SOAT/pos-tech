package br.com.fiap.pos.soat3.lanchonete.infrastructure.config.errorhandler;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.config.exception.EntityExistsException;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.config.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(status, errors);

        log.error(String.format("Lanchonete Error: %s", errors.get(0)));

        return new ResponseEntity<>(apiErrorMessage, apiErrorMessage.getStatus());
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handlerEntityNotFoundException(EntityNotFoundException exception,
                                                                 WebRequest request) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        log.error(String.format("Lanchonete Error: %s", exception.getMessage()));

        return new ResponseEntity<>(apiErrorMessage, new HttpHeaders(), apiErrorMessage.getStatus());
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handlerEntityNotFoundException(EntityExistsException exception,
                                                                 WebRequest request) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());

        log.error(String.format("Lanchonete Error: %s", exception.getMessage()));

        return new ResponseEntity<>(apiErrorMessage, new HttpHeaders(), apiErrorMessage.getStatus());
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Object> handlerEntityNotFoundException(GenericException exception,
                                                                 WebRequest request) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());

        log.error(String.format("Lanchonete Error: %s", exception.getMessage()));

        return new ResponseEntity<>(apiErrorMessage, new HttpHeaders(), apiErrorMessage.getStatus());
    }

}
