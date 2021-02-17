package com.zup.vacinas.core;

import com.zup.vacinas.dto.UsuarioDTORequest;
import com.zup.vacinas.dto.UsuarioDTOResponse;
import com.zup.vacinas.dto.VacinaDTORequest;
import com.zup.vacinas.dto.VacinaDTOResponse;
import com.zup.vacinas.model.Usuario;
import com.zup.vacinas.model.Vacina;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    
    public Usuario usuarioDtoParaModel(UsuarioDTORequest dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setEmail(dto.getEmail());
        usuario.setDataDeNascimento(dto.getDataDeNascimento());
        return usuario;
    }

    public UsuarioDTOResponse usuarioModelParaDto(Usuario usuario) {
        UsuarioDTOResponse dto = new UsuarioDTOResponse();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    public Vacina vacinaDtoParaModel(VacinaDTORequest dto) {
        Vacina vacina = new Vacina();
        vacina.setDataDaAplicacao(dto.getDataDaAplicacao());
        vacina.setNome(dto.getNome());
        return vacina;
    }

    public VacinaDTOResponse vacinaModelParaDto(Vacina vacina) {
        VacinaDTOResponse dto = new VacinaDTOResponse();
        dto.setId(vacina.getId());
        dto.setNomeUsuario(vacina.getUsuario().getNome());
        dto.setEmail(vacina.getUsuario().getEmail());
        dto.setNome(vacina.getNome());
        dto.setDataDaAplicacao(vacina.getDataDaAplicacao());
        return dto;
    }
}
