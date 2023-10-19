package br.com.fiap.pos.soat3.lanchonete.domain.usecase;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.RecuperaCategoriaUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaCategoriaAdapterPort;

public class RecuperaCategoriaUseCase implements RecuperaCategoriaUseCasePort {
    
    private RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort;
    @Override
    public Categoria execute(Long id) {
        return recuperaCategoriaAdapterPort.recuperaCategoriaById(id);
    }
}
