package br.com.fiap.pos.soat3.lanchonete.domain.entity;

public class Categoria {

    private Long id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(Long id) {
        this.id = id;
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
