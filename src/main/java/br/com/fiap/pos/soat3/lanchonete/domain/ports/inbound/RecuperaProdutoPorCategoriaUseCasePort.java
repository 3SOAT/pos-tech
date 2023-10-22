package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import java.util.List;

public interface RecuperaProdutoPorCategoriaUseCasePort {
    
    List<Produto> execute(Long id);
}
