package com.zup.vacinas.controller;

import java.util.List;

import javax.validation.Valid;

import com.zup.vacinas.core.BaseController;
import com.zup.vacinas.dto.UsuarioDTORequest;
import com.zup.vacinas.dto.UsuarioDTOResponse;
import com.zup.vacinas.model.Usuario;
import com.zup.vacinas.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController extends BaseController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public UsuarioService getService() {
        return this.usuarioService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<UsuarioDTOResponse> criar(@Valid @RequestBody UsuarioDTORequest dtoRequest) {
        try{
            Usuario usuario = usuarioDtoParaModel(dtoRequest);
            getService().criar(usuario);
            UsuarioDTOResponse dtoResponse = usuarioModelParaDto(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
        
        }catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<UsuarioDTOResponse> buscarPorId(@PathVariable("id") Integer id) {
        try{
            Usuario usuario = getService().buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioModelParaDto(usuario));
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(getService().buscarTodos());
    }
}
