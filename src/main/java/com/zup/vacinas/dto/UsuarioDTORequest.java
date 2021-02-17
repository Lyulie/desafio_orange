package com.zup.vacinas.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class UsuarioDTORequest {

    private Integer id;

    @NotEmpty(message = "Nome não pode ser vazio!")
    @Size(min = 3, max = 255, message = "O nome deve conter de 3 a 255 caracteres!")
    private String nome;
    
    @NotEmpty(message = "O campo email é obrigatório!")
    @Email(message = "Email inválido")
    private String email;

    @CPF(message = "O campo CPF é obrigatório!")
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória!")
    private LocalDate dataDeNascimento;

    @Deprecated
    public UsuarioDTORequest() {
    }

    public UsuarioDTORequest(Integer id, String nome, String email, String cpf, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
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

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

}
