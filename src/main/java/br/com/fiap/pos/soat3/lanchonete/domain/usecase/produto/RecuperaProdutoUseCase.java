package br.com.fiap.pos.soat3.lanchonete.domain.usecase.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.RecuperaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.categoria.RecuperaCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.RecuperaProdutoAdapterPort;

public class RecuperaProdutoUseCase implements RecuperaProdutoUseCasePort {
    
    private final RecuperaProdutoAdapterPort recuperaProdutoAdapterPort;
    
    private final RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort;

    public RecuperaProdutoUseCase(RecuperaProdutoAdapterPort recuperaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort) {
        this.recuperaProdutoAdapterPort = recuperaProdutoAdapterPort;
        this.recuperaCategoriaAdapterPort = recuperaCategoriaAdapterPort;
    }

    @Override
    public Produto execute(Long id) {
        Produto produto = recuperaProdutoAdapterPort.recuperaProduto(id);
        produto.setCategoria(recuperaCategoriaAdapterPort.recuperaCategoriaById(produto.getCategoria().getId()));
        return produto;
    }
}
