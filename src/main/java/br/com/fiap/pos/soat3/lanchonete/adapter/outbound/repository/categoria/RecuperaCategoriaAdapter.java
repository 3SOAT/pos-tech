package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.categoria;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.categoria.mapper.CategoriaMapper;
import br.com.fiap.pos.soat3.lanchonete.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.categoria.RecuperaCategoriaAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class RecuperaCategoriaAdapter implements RecuperaCategoriaAdapterPort {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public RecuperaCategoriaAdapter(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public Categoria recuperaCategoriaById(Long id) {
        try {
            var categoriaEntity = categoriaRepository.findById(id);  
            return categoriaMapper.fromEntity(categoriaEntity.get());
        } catch(Exception exception) {
            throw new EntityNotFoundException("Categoria", String.valueOf(id));
        }
    }
}
