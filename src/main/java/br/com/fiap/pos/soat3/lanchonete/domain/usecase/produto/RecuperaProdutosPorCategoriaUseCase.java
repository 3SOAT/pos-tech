package br.com.fiap.pos.soat3.lanchonete.domain.usecase.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.RecuperaProdutoPorCategoriaUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.RecuperaProdutoPorCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.categoria.RecuperaCategoriaAdapterPort;

import java.util.List;

public class RecuperaProdutosPorCategoriaUseCase implements RecuperaProdutoPorCategoriaUseCasePort {

    private final RecuperaProdutoPorCategoriaAdapterPort recuperaProdutoPorCategoriaAdapterPort;

    private final RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort;

    public RecuperaProdutosPorCategoriaUseCase(RecuperaProdutoPorCategoriaAdapterPort recuperaProdutoPorCategoriaAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort) {
        this.recuperaProdutoPorCategoriaAdapterPort = recuperaProdutoPorCategoriaAdapterPort;
        this.recuperaCategoriaAdapterPort = recuperaCategoriaAdapterPort;
    }

    @Override
    public List<Produto> execute(Long id) {
        List<Produto> produtos = recuperaProdutoPorCategoriaAdapterPort.recuperaProdutoPorCategoria(id);
        produtos.forEach(prod ->
                prod.setCategoria(recuperaCategoriaAdapterPort.recuperaCategoriaById(prod.getCategoria().getId())));
        return produtos;
    }

}
