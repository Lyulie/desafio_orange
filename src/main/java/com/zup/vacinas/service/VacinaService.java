package com.zup.vacinas.service;

import java.util.List;

import com.zup.vacinas.model.Vacina;
import com.zup.vacinas.repository.VacinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {
    
    private VacinaRepository vacinaRepository;

    @Autowired
    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    public VacinaRepository getRepository() {
        return this.vacinaRepository;
    }

    public Vacina criar(Vacina vacina) {
        return getRepository().save(vacina);
    }

    public Vacina buscarPorId(Integer id) {
        try {
            return getRepository().findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Cadastro de vacinação inexistente!");
        }
        
    }

	public List<Vacina> buscarTodos() {
		return getRepository().findAll();
	}
}
