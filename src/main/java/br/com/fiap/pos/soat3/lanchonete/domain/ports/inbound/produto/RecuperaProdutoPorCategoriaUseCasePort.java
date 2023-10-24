package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import java.util.List;

public interface RecuperaProdutoPorCategoriaUseCasePort {
    
    List<Produto> execute(Long id);
}
