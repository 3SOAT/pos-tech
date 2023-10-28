package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto.mapper.ProdutoMapper;
import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.RecuperaProdutoAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class RecuperaProdutoAdapter implements RecuperaProdutoAdapterPort {
    
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public RecuperaProdutoAdapter(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public Produto recuperaProduto(Long id) {
        try{
            var produto = produtoRepository.findById(id);
            return produtoMapper.fromEntity(produto.get());
        } catch (Exception e) {
            throw new EntityNotFoundException("Produto", String.valueOf(id));
        }
        
    }
}
