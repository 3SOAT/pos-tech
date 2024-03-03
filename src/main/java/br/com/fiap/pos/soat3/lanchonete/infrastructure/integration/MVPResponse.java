package br.com.fiap.pos.soat3.lanchonete.infrastructure.integration;

public class MVPResponse {

    private String code;

    private String url;

    public MVPResponse(String code, String url) {
        this.code = code;
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
