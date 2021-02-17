package com.zup.vacinas.repository;

import com.zup.vacinas.model.Vacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Integer> {
    
}
