package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;

public interface CriaProdutoUseCasePort {
    
    Produto execute(Produto produto);
}
