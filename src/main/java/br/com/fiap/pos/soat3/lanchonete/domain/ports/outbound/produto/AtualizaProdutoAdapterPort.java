package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;

public interface AtualizaProdutoAdapterPort {
    
    Produto atualizaProduto(Produto produto);
}
