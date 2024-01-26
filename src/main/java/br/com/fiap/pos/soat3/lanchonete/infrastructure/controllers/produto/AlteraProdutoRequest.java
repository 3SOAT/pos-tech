package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;

import java.math.BigDecimal;

public class AlteraProdutoRequest {

    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal valor;
    private Long categoriaId;

    public AlteraProdutoRequest(){

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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
