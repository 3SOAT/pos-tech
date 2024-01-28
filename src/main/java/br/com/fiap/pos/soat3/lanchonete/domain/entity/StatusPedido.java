package br.com.fiap.pos.soat3.lanchonete.domain.entity;

public enum StatusPedido {
    GERADO("Gerado"),
    RECEBIDO("Recebido"),
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    RECUSADO("Problemas no pagamento"),
    CANCELADO("Cancelado"),
    PREPARACAO("Em preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado");

    private String status;

    StatusPedido(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
