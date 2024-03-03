package br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.categoria;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto.ProdutoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collection;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "categoria")
    private Collection<ProdutoEntity> produtos;

    public CategoriaEntity(String nome) {
        this.nome = nome;
    }

    public CategoriaEntity(Long id) {
        this.id = id;
    }

    public CategoriaEntity() {

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

    public Collection<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(Collection<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }
}
