package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.AtualizaProdutoAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AtualizaProdutoAdapter implements AtualizaProdutoAdapterPort{
    
    private final ProdutoRepository produtoRepository;

    public AtualizaProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public Produto atualizaProduto(Produto produto) {
        ProdutoEntity produtoEntity = produtoRepository.findById(produto.getId()).get();
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setImagem(produto.getImagem());
        produtoEntity.setValor(String.valueOf(produto.getValor()));
        produtoEntity.setCategoriaId(produto.getCategoria().getId());
        produtoRepository.save(produtoEntity);
        return produto;
    }
}
