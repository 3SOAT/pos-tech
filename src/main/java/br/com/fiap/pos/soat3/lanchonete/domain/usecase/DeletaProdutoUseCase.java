package br.com.fiap.pos.soat3.lanchonete.domain.usecase;

import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.DeletaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.DeletaProdutoAdapterPort;

public class DeletaProdutoUseCase implements DeletaProdutoUseCasePort {
    
    private final DeletaProdutoAdapterPort deletaProdutoAdapterPort;

    public DeletaProdutoUseCase(DeletaProdutoAdapterPort deletaProdutoAdapterPort) {
        this.deletaProdutoAdapterPort = deletaProdutoAdapterPort;
    }
    
    @Override
    public void execute(Long id) {
        deletaProdutoAdapterPort.deletaProduto(id);
    }
}
