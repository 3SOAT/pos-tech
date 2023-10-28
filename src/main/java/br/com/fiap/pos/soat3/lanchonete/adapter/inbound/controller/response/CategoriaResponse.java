package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;

public class CategoriaResponse {

    private Long id;

    private String nome;

    public CategoriaResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static CategoriaResponse fromDomain(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
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
