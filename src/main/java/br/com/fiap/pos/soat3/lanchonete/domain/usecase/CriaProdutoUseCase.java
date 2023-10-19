package br.com.fiap.pos.soat3.lanchonete.domain.usecase;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.CriaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.SalvaProdutoAdapterPort;

public class CriaProdutoUseCase implements CriaProdutoUseCasePort {
    
    private final SalvaProdutoAdapterPort salvaProdutoAdapterPort;
    
    private final RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort;

    public CriaProdutoUseCase(SalvaProdutoAdapterPort salvaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort) {
        this.salvaProdutoAdapterPort = salvaProdutoAdapterPort;
        this.recuperaCategoriaAdapterPort = recuperaCategoriaAdapterPort;
    }

    @Override
    public Produto execute(Produto produto) {
        produto.setCategoria(recuperaCategoriaAdapterPort.recuperaCategoriaById(produto.getCategoria().getId()));
        return salvaProdutoAdapterPort.salvaProduto(produto);
    }
}
