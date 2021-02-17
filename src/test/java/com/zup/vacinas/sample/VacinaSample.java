package com.zup.vacinas.sample;

import java.time.LocalDate;

import com.zup.vacinas.dto.VacinaDTORequest;
import com.zup.vacinas.dto.VacinaDTOResponse;
import com.zup.vacinas.model.Usuario;
import com.zup.vacinas.model.Vacina;

public class VacinaSample {

    private static Integer id = 1;
    private static String nome = "Vacina 1";
    private static LocalDate dataDaAplicacao = LocalDate.of(2021, 1, 1);
    private static Usuario usuario = UsuarioSample.gerarUsuario();

    public static Vacina gerarVacina() {
        return new Vacina(id, nome, dataDaAplicacao, usuario);
    }

    public static VacinaDTORequest gerarVacinaDTORequest() {
        return new VacinaDTORequest(id, nome, dataDaAplicacao, usuario.getId());
    }

    public static VacinaDTOResponse gerarVacinaDTOResponse() {
        return new VacinaDTOResponse(id, usuario.getNome(), usuario.getEmail(), nome, dataDaAplicacao);
    }
}
