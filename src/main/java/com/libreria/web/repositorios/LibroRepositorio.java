package com.libreria.web.repositorios;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.libreria.web.entidades.Libro;

@Repository
public interface LibroRepositorio extends JpaRepositoryImplementation<Libro, String>{

	
	
}
