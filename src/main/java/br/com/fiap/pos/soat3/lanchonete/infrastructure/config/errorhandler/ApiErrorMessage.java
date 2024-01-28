package br.com.fiap.pos.soat3.lanchonete.infrastructure.config.errorhandler;

import org.springframework.http.HttpStatusCode;

import java.util.Collections;
import java.util.List;

public class ApiErrorMessage {

    private HttpStatusCode status;

    private List<String> errors;

    public ApiErrorMessage(HttpStatusCode status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatusCode status, String error) {
        this.status = status;
        this.errors = Collections.singletonList(error);
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
