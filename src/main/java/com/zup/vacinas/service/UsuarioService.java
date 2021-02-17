package com.zup.vacinas.service;

import java.util.List;

import com.zup.vacinas.model.Usuario;
import com.zup.vacinas.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioRepository getRepository() {
        return this.usuarioRepository;
    }

    public Usuario criar(Usuario usuario) {
        validar(usuario);
        return getRepository().save(usuario);
    }

    private void validar(Usuario usuario) {
        
        String email = usuario.getEmail();
        int indexAtSign = email.indexOf("@");
        String domain = email.substring(indexAtSign + 1, email.length());

        if(!domain.contains(".")) {
            throw new RuntimeException("Email sem domínio!");
        }

        if(buscarPorCpf(usuario.getCpf()) != null) {
            throw new RuntimeException("Usuário já cadastrado!");
        }

        if(buscarPorEmail(usuario.getEmail()) != null) {
            throw new RuntimeException("Usuário já cadastrado!");
        }
    }

    private Usuario buscarPorEmail(String email) {
        return getRepository().findByEmail(email);
    }

    public Usuario buscarPorId(Integer id) {
        return getRepository().findById(id).get();
    }

    public Usuario buscarPorCpf(String cpf) {
        return getRepository().findByCpf(cpf);
    }

	public List<Usuario> buscarTodos() {
		return getRepository().findAll();
	}
}
