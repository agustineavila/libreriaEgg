package com.libreria.web.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.web.entidades.Autor;
import com.libreria.web.entidades.Editorial;
import com.libreria.web.entidades.Libro;
import com.libreria.web.errores.ErrorServicio;
import com.libreria.web.repositorios.LibroRepositorio;

@Service
public class LibroServicio { 

	@Autowired
	private LibroRepositorio libroRepositorio;
	
	public void registrarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) throws ErrorServicio{
		
		validarLibro(isbn, titulo, anio, ejemplares, autor, editorial);
		
		Libro libro = new Libro();
		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAnio(anio);
		libro.setEjemplares(ejemplares);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
		libro.setAlta(false);
		
		libroRepositorio.save(libro);
	}
	
	
	public void modificarLibro(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) throws ErrorServicio {
		
		validarLibro(isbn, titulo, anio, ejemplares, autor, editorial);
		
		Optional<Libro> respuesta = libroRepositorio.findById(id);
		if(respuesta.isPresent()) {
			Libro libro = libroRepositorio.findById(id).get();
			libro.setIsbn(isbn);
			libro.setTitulo(titulo);
			libro.setAnio(anio);
			libro.setEjemplares(ejemplares);
			libro.setAutor(autor);
			libro.setEditorial(editorial);
			
			libroRepositorio.save(libro);
		}else {
			throw new ErrorServicio("No se encontro el libro.");
		}
		
	}
	
	public void habilitarLibro(String id) throws ErrorServicio {
		Optional<Libro> respuesta = libroRepositorio.findById(id);
		if(respuesta.isPresent()) {
			Libro libro = respuesta.get();
			libro.setAlta(true);
			
			libroRepositorio.save(libro);
		}else {
			throw new ErrorServicio("No se encontro el libro.");
		}
	}
	
	public void deshabilitarLibro(String id) throws ErrorServicio {	
		Optional<Libro> respuesta = libroRepositorio.findById(id);
		if(respuesta.isPresent()) {
			Libro libro = respuesta.get();
			libro.setAlta(false);
			
			libroRepositorio.save(libro);
		}else {
			throw new ErrorServicio("No se encontro el libro.");
		}
	}
	
	
	
	private void validarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) throws ErrorServicio {
		if(isbn == null || isbn == 0) {
			throw new ErrorServicio("El isbn es un campo obligatorio.");
		}
		if(titulo == null || titulo.isEmpty()) {
			throw new ErrorServicio("El Titulo es un campo obligatorio.");
		}
		if(anio == null || anio == 0) {
			throw new ErrorServicio("El anio es un campo obligatorio.");
		}
		if(ejemplares == null || ejemplares == 0) {
			throw new ErrorServicio("La cantidad de ejemplares es un campo obligatorio.");
		}
	}
}
