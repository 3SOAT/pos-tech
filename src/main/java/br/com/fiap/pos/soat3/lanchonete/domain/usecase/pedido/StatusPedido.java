package br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido;

public enum StatusPedido {
    GERADO("Gerado"),
    RECEBIDO("Recebido"),
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    RECUSADO("Problemas no pagamento"),
    CANCELADO("Cancelado"),
    PREPARACAO("Em preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado");

    StatusPedido(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }
}
