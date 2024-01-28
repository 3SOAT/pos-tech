package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfirmacaoResponse {

    @JsonProperty("resultado")
    private String resultado;

    public ConfirmacaoResponse() {
    }

    public ConfirmacaoResponse(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
