package br.com.fiap.pos.soat3.lanchonete.clean.infrastructure.persistence.categoria;

import jakarta.persistence.*;

@Entity
@Table(name = "categoriaclean")
public class CategoriaCleanEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
  private Long id;

  @Column(name = "nome")
  private String nome;

  public CategoriaCleanEntity(String nome) {
    this.nome = nome;
  }

  public CategoriaCleanEntity() {

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