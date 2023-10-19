package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;

public interface RecuperaCategoriaAdapterPort {
    
    Categoria recuperaCategoriaById(Long id);
}
