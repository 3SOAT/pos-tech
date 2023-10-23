package br.com.fiap.pos.soat3.lanchonete.domain.domain;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.categoria.CategoriaEntity;

public class Categoria {
    
    private Long id;
    private String nome;

    public Categoria(Long id) {
        this.id = id;
        this.nome = "";
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Categoria fromEntity(CategoriaEntity categoriaEntity) {
        return new Categoria(categoriaEntity.getId(), categoriaEntity.getNome());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
