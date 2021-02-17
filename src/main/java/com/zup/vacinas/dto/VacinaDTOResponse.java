package com.zup.vacinas.dto;

import java.time.LocalDate;

public class VacinaDTOResponse {
    
    private Integer id;
    private String nomeUsuario;
    private String email;
    private String nome;
    private LocalDate dataDaAplicacao;

    @Deprecated
    public VacinaDTOResponse() {
    }

    public VacinaDTOResponse(Integer id, String nomeUsuario, String email, String nome, LocalDate dataDaAplicacao) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.nome = nome;
        this.dataDaAplicacao = dataDaAplicacao;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDaAplicacao() {
        return this.dataDaAplicacao;
    }

    public void setDataDaAplicacao(LocalDate dataDaAplicacao) {
        this.dataDaAplicacao = dataDaAplicacao;
    }

}
