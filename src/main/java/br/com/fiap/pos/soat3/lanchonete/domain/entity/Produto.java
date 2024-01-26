package br.com.fiap.pos.soat3.lanchonete.domain.entity;


import java.math.BigDecimal;

public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal valor;
    private Categoria categoria;

    public Produto(Long id, String nome, String descricao, String imagem, BigDecimal valor, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.valor = valor == null ? BigDecimal.ZERO : valor;
        this.categoria = categoria;
    }

    public Produto(String nome, String descricao, String imagem, BigDecimal valor, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.valor = valor == null ? BigDecimal.ZERO : valor;
        this.categoria = categoria;
    }

    public Produto() {

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
