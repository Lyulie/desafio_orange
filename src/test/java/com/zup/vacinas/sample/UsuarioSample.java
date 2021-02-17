package com.zup.vacinas.sample;

import java.time.LocalDate;

import com.zup.vacinas.dto.UsuarioDTORequest;
import com.zup.vacinas.dto.UsuarioDTOResponse;
import com.zup.vacinas.model.Usuario;

public class UsuarioSample {

    private static Integer id = 1;
    private static String nome = "Usuario 1";
    private static String email = "email@email.com";
    private static String cpf = "70588877050";
    private static LocalDate dataDeNascimento = LocalDate.of(2021, 1, 1);

    public static Usuario gerarUsuario() {
        return new Usuario(id, nome, email, cpf, dataDeNascimento);
    }

    public static UsuarioDTORequest gerarUsuarioDTORequest() {
        return new UsuarioDTORequest(id, nome, email, cpf, dataDeNascimento);
    }

    public static UsuarioDTOResponse gerarUsuarioDTOResponse() {
        return new UsuarioDTOResponse(id, nome, email);
    }
}
