package com.zup.vacinas.controller;

import java.util.List;

import javax.validation.Valid;

import com.zup.vacinas.core.BaseController;
import com.zup.vacinas.dto.VacinaDTORequest;
import com.zup.vacinas.dto.VacinaDTOResponse;
import com.zup.vacinas.model.Vacina;
import com.zup.vacinas.service.UsuarioService;
import com.zup.vacinas.service.VacinaService;

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
@RequestMapping(value = "vacinas")
public class VacinaController extends BaseController {
    
    private VacinaService vacinaService;
    private UsuarioService usuarioService;

    @Autowired
    public VacinaController(VacinaService vacinaService, UsuarioService usuarioService) {
        this.vacinaService = vacinaService;
        this.usuarioService = usuarioService;
    }

    public VacinaService getVacinaService() {
        return this.vacinaService;
    }
    
    public UsuarioService getUsuarioService() {
        return this.usuarioService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<VacinaDTOResponse> criar(@Valid @RequestBody VacinaDTORequest dtoRequest) {
        try{
            Vacina vacina = vacinaDtoParaModel(dtoRequest);
            vacina.setUsuario(getUsuarioService().buscarPorId(dtoRequest.getUsuarioId()));
            getVacinaService().criar(vacina);
            VacinaDTOResponse dtoResponse = vacinaModelParaDto(vacina);
            return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<VacinaDTOResponse> buscarPorId(@PathVariable("id") Integer id) {
        try {
            Vacina vacina = getVacinaService().buscarPorId(id);
            VacinaDTOResponse dto = vacinaModelParaDto(vacina);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Vacina>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(getVacinaService().buscarTodos());
    }
}
