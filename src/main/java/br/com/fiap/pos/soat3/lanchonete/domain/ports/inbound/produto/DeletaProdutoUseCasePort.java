package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto;

public interface DeletaProdutoUseCasePort {
    
    void execute(Long id);
}
