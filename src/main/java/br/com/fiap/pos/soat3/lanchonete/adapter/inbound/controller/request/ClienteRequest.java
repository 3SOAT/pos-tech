package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.request;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;

public class ClienteRequest {

    private Long id;
    private String nome;
    private String email;
    private String CPF;

    public ClienteRequest(Long id, String nome, String email, String CPF) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    public Cliente toClienteDomain() {
        return new Cliente(nome, email, CPF);
    }

    public Cliente toClienteDomain(Long id) {
        return new Cliente(id, nome, email, CPF);
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
