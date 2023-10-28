package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.DeletaProdutoAdapterPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeletaProdutoAdapter implements DeletaProdutoAdapterPort {

    private final Logger log = LoggerFactory.getLogger(DeletaProdutoAdapter.class);
    
    private final ProdutoRepository produtoRepository;

    public DeletaProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public void deletaProduto(Long id) {
        log.info(String.format("Lanchonete: Deletando produto %s", id));
        produtoRepository.deleteById(id);
    }
}
