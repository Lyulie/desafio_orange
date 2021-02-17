package com.zup.vacinas.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vacina")
public class Vacina implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @DateTimeFormat
    @Column(name = "data_da_aplicacao")
    private LocalDate dataDaAplicacao;

    @ManyToOne
    private Usuario usuario;

    @Deprecated
    public Vacina() {
    }

    public Vacina(Integer id, String nome, LocalDate dataDaAplicacao, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.dataDaAplicacao = dataDaAplicacao;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
