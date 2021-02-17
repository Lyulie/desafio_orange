package com.zup.vacinas.dto;

public class UsuarioDTOResponse {
    
    private Integer id;
    private String nome;
    private String email;

    @Deprecated
    public UsuarioDTOResponse() {
    }

    public UsuarioDTOResponse(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
}
