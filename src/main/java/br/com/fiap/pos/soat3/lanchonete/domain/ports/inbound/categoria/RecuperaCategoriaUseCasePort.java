package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.categoria;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;

public interface RecuperaCategoriaUseCasePort {
    
    Categoria execute(Long id);
}
