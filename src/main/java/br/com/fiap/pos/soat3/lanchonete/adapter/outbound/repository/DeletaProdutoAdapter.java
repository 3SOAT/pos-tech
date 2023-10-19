package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository;

import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.DeletaProdutoAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeletaProdutoAdapter implements DeletaProdutoAdapterPort {
    
    private final ProdutoRepository produtoRepository;

    public DeletaProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public void deletaProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
