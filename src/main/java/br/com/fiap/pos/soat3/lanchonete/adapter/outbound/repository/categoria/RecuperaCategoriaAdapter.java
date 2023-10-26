package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.categoria;

import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.categoria.RecuperaCategoriaAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class RecuperaCategoriaAdapter implements RecuperaCategoriaAdapterPort {
    
    private final CategoriaRepository categoriaRepository;

    public RecuperaCategoriaAdapter(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria recuperaCategoriaById(Long id) {
        try {
            var categoriaEntity = categoriaRepository.findById(id);  
            return Categoria.fromEntity(categoriaEntity.get());
        } catch(Exception exception) {
            throw new EntityNotFoundException("Categoria", String.valueOf(id));
        }
    }
}
