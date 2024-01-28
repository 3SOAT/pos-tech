package br.com.fiap.pos.soat3.lanchonete.domain.entity;

public class Pagamento {

    private Long id;

    private Pedido pedido;

    private String qrCode;

    private String webhook;

    public Pagamento() {

    }

    public Pagamento(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pagamento(Pedido pedido, String qrCode) {
        this.pedido = pedido;
        this.qrCode = qrCode;
    }

    public Pagamento(Long id, Pedido pedido, String qrCode) {
        this.id = id;
        this.pedido = pedido;
        this.qrCode = qrCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }
}
