package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.cliente;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    public ClienteEntity() {
    }

    public ClienteEntity(Long id, String nome, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public static ClienteEntity fromDomain(Cliente cliente) {
        return new ClienteEntity(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCPF());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
