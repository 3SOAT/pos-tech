package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.SalvaProdutoAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SalvaProdutoAdapter implements SalvaProdutoAdapterPort {
    
    private final ProdutoRepository produtoRepository;

    public SalvaProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public Produto salvaProduto(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setImagem(produto.getImagem());
        produtoEntity.setValor(String.valueOf(produto.getValor()));
        produtoEntity.setCategoriaId(produto.getCategoria().getId());
        produto.setId(produtoRepository.save(produtoEntity).getId());
        return produto;
    }
}
