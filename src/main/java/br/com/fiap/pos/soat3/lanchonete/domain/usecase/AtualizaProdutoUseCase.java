package br.com.fiap.pos.soat3.lanchonete.domain.usecase;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.AtualizaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.AtualizaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaCategoriaAdapterPort;

public class AtualizaProdutoUseCase implements AtualizaProdutoUseCasePort {
    
    private final AtualizaProdutoAdapterPort atualizaProdutoAdapterPort;

    private final RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort;

    public AtualizaProdutoUseCase(AtualizaProdutoAdapterPort atualizaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort) {
        this.atualizaProdutoAdapterPort = atualizaProdutoAdapterPort;
        this.recuperaCategoriaAdapterPort = recuperaCategoriaAdapterPort;
    }

    @Override
    public Produto execute(Produto produto) {
        produto.setCategoria(recuperaCategoriaAdapterPort.recuperaCategoriaById(produto.getCategoria().getId()));
        return atualizaProdutoAdapterPort.atualizaProduto(produto);
    }
}
