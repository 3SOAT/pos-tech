package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto.mapper.ProdutoMapper;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.SalvaProdutoAdapterPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SalvaProdutoAdapter implements SalvaProdutoAdapterPort {

    private final Logger log = LoggerFactory.getLogger(SalvaProdutoAdapter.class);

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public SalvaProdutoAdapter(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    @Transactional
    public Produto salvaProduto(Produto produto) {
        ProdutoEntity produtoEntity = produtoMapper.getEntityFromDomain(produto);
        produto.setId(produtoRepository.save(produtoEntity).getId());

        log.info(String.format("Lanchonete: Salvando produto %s", produto.getId()));
        return produto;
    }
}
