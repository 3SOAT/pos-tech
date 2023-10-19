package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;

public interface RecuperaCategoriaUseCasePort {
    
    Categoria execute(Long id);
}
