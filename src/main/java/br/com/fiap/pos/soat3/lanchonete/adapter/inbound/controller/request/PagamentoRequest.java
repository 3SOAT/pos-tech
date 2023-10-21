package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.request;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PagamentoRequest {

    @NotNull
    private Long id;

    private Long clientId;

    @Size(min=1)
    private List<Produto> produtos;

    public static Pagamento toDomain() {
//        return new Pagamento(id, clientId, produtos);
    }
}
