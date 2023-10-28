package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.categoria.mapper;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.categoria.CategoriaEntity;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria fromEntity(CategoriaEntity categoriaEntity) {
        return new Categoria(categoriaEntity.getId(), categoriaEntity.getNome());
    }
}
