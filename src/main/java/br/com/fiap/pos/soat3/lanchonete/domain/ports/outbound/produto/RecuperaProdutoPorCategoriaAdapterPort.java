package br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import java.util.List;

public interface RecuperaProdutoPorCategoriaAdapterPort {
    
    List<Produto> recuperaProdutoPorCategoria(Long id);
}
