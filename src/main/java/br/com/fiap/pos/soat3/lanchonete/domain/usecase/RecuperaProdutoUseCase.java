package br.com.fiap.pos.soat3.lanchonete.domain.usecase;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.RecuperaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaProdutoAdapterPort;

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
