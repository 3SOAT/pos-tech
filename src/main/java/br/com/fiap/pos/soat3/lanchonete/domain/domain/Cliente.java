package br.com.fiap.pos.soat3.lanchonete.domain.domain;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.ClienteEntity;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String CPF;

    public static Cliente fromEntity(ClienteEntity clienteEntity) {
        return new Cliente(
                clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getEmail(),
                clienteEntity.getCpf());
    }

    public Cliente(Long id, String nome, String email, String CPF) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    public Cliente(String nome, String email, String CPF) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) {
        this.CPF = cpf;
    }
}
