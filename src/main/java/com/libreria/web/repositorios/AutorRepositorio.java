package com.libreria.web.repositorios;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.libreria.web.entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepositoryImplementation<Autor, String>{

	
	
}
