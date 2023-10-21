package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.request;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProdutoRequest {
    
    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private String imagem;

    @NotEmpty
    private String valor;
    
    @NotNull
    private Long categoriaId;
    
    public Produto toDomain(){
        return new Produto(nome, descricao, imagem, new BigDecimal(valor), new Categoria(categoriaId));
    }

    public Produto toDomain(Long id){
        return new Produto(id, nome, descricao, imagem, new BigDecimal(valor), new Categoria(categoriaId));
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
