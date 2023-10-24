package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.RecuperaProdutoPorCategoriaAdapterPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecuperaProdutoPorCategoriaAdapter implements RecuperaProdutoPorCategoriaAdapterPort {

    private final ProdutoRepository produtoRepository;

    public RecuperaProdutoPorCategoriaAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> recuperaProdutoPorCategoria(Long id) {
        try{
            var produtosEntity = produtoRepository.findByCategoriaId(id);
            return produtosEntity
                    .stream()
                    .map(produto -> (Produto) Produto.fromEntity(produto))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new EntityNotFoundException("Produto", String.valueOf(id));
        }
        
    }
}
