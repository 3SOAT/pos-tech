package br.com.fiap.pos.soat3.lanchonete.domain.usecase.categoria;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.categoria.RecuperaCategoriaUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.categoria.RecuperaCategoriaAdapterPort;

public class RecuperaCategoriaUseCase implements RecuperaCategoriaUseCasePort {
    
    private RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort;
    @Override
    public Categoria execute(Long id) {
        return recuperaCategoriaAdapterPort.recuperaCategoriaById(id);
    }
}
