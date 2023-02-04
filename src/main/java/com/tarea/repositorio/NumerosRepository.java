package com.tarea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarea.entidad.Numeros;

@Repository
public interface NumerosRepository extends JpaRepository<Numeros, Long> {
	
}
