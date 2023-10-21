package br.com.fiap.pos.soat3.lanchonete.domain.domain;

public class Pagamento {
    
    private Long id;
    
    private Pedido pedido;
    
    private String qrCode;

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
}
