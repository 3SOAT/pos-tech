package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Produto;

public class ProdutoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private String valor;
    private CategoriaResponse categoria;

    public ProdutoResponse(Long id, String nome, String descricao, String imagem, String valor, CategoriaResponse categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.valor = valor;
        this.categoria = categoria;
    }

    public static ProdutoResponse fromDomain(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getImagem(),
                String.valueOf(produto.getValor()), CategoriaResponse.fromDomain(produto.getCategoria()));
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public CategoriaResponse getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponse categoria) {
        this.categoria = categoria;
    }
}
