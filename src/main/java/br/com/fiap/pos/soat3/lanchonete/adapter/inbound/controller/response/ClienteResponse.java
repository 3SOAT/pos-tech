package br.com.fiap.pos.soat3.lanchonete.adapter.inbound.controller.response;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;

public class ClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private String CPF;

    public ClienteResponse(Long id, String nome, String email, String CPF) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    public static ClienteResponse fromDomain(Cliente cliente){
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCPF());
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
