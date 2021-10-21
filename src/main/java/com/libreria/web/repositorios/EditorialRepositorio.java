package com.libreria.web.repositorios;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.libreria.web.entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepositoryImplementation<Editorial, String>{

}
