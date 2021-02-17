package com.zup.vacinas.repository;

import com.zup.vacinas.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByCpf(String cpf);

	Usuario findByEmail(String email);
    
}
