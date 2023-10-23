package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.RecuperaProdutoAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class RecuperaProdutoAdapter implements RecuperaProdutoAdapterPort {
    
    private final ProdutoRepository produtoRepository;

    public RecuperaProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto recuperaProduto(Long id) {
        try{
            var produto = produtoRepository.findById(id);
            return Produto.fromEntity(produto.get());    
        } catch (Exception e) {
            throw new EntityNotFoundException("Produto", id);
        }
        
    }
}
