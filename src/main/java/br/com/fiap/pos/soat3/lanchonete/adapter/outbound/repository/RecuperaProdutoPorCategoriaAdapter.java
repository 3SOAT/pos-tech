package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository;

import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaProdutoPorCategoriaAdapterPort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
            throw new EntityNotFoundException("Produto", id);
        }
        
    }
}
