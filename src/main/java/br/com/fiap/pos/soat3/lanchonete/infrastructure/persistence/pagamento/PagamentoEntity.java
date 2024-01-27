package br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pagamento;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;
    @Column(name = "pedido_id")
    private Long pedidoId;

    @Column(name = "qr_code")
    private String qrCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}