package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;

public interface AtualizaProdutoUseCasePort {
    
    Produto execute(Produto produto);
}
