package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.produto.mapper.ProdutoMapper;
import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.AtualizaProdutoAdapterPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class AtualizaProdutoAdapter implements AtualizaProdutoAdapterPort {

    private final Logger log = LoggerFactory.getLogger(AtualizaProdutoAdapter.class);

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public AtualizaProdutoAdapter(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    @Transactional
    public Produto atualizaProduto(Produto produto) {

        if(produtoRepository.existsById(produto.getId())) {
            ProdutoEntity produtoEntity = produtoMapper.getEntityFromDomain(produto);
            produtoRepository.save(produtoEntity);
        } else {
            throw new EntityNotFoundException("Produto", produto.getId().toString());
        }

        log.info(String.format("Lanchonete: Atualizando produto %s", produto.getId()));
        return produto;
    }
}
