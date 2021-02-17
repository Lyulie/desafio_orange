package com.zup.vacinas.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VacinaDTORequest {

    private Integer id;

    @NotEmpty(message = "Nome não pode ser vazio!")
    @Size(min = 3, max = 255, message = "O nome deve conter de 3 a 255 caracteres!")
    private String nome;

    @NotNull(message = "A data de aplicação é obrigatória!")
    private LocalDate dataDaAplicacao;

    @NotNull(message = "O id do usuário é obrigatório!")
    private Integer usuarioId;

    @Deprecated
    public VacinaDTORequest() {
    }

    public VacinaDTORequest(Integer id, String nome, LocalDate dataDaAplicacao, Integer usuarioId) {
        this.id = id;
        this.nome = nome;
        this.dataDaAplicacao = dataDaAplicacao;
        this.usuarioId = usuarioId;
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

    public LocalDate getDataDaAplicacao() {
        return this.dataDaAplicacao;
    }

    public void setDataDaAplicacao(LocalDate dataDaAplicacao) {
        this.dataDaAplicacao = dataDaAplicacao;
    }

    public Integer getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
