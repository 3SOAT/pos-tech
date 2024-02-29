package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.produto;

import br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.categoria.CategoriaCleanEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "produtoclean")
public class ProdutoCleanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private String valor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "imagem")
    private String imagem;

    @JoinColumn(name = "categoria_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = CategoriaCleanEntity.class, fetch = FetchType.EAGER)
    private CategoriaCleanEntity categoria;

    @Column(name = "categoria_id")
    private Long categoriaId;

    public ProdutoCleanEntity(String nome, String valor, String descricao, String imagem, Long categoriaId) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categoriaId = categoriaId;
    }

    public ProdutoCleanEntity() {

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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

    public CategoriaCleanEntity getCategoria() { return categoria;}

    public void setCategoria(CategoriaCleanEntity categoria) { this.categoria = categoria;}
}
