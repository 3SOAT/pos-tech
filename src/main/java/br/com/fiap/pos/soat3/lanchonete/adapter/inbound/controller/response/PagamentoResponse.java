package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;

public class PagamentoResponse {
    
    private Long id;
    
    private PedidoResponse pedido;
    
    private String qrCode;

    public PagamentoResponse(Long id, PedidoResponse pedido, String qrCode) {
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

    public PedidoResponse getPedido() {
        return pedido;
    }

    public void setPedido(PedidoResponse pedido) {
        this.pedido = pedido;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public static PagamentoResponse fromDomain(Pagamento pagamento){
        return new PagamentoResponse(pagamento.getId(), 
                PedidoResponse.fromDomain(pagamento.getPedido()),
                pagamento.getQrCode());        
    }
}
