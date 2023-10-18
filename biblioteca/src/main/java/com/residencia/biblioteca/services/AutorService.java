package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Autor;
import com.residencia.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {
	@Autowired
	AutorRepository autorRep;

	public List<Autor> listarAutor() {
		return autorRep.findAll();
	}

	public Autor buscarAutorId(Integer id) {
		return autorRep.findById(id).orElse(null);
	}

	public Autor salvarAutor(Autor autor) {
		return autorRep.save(autor);
	}

	public Autor atualizarAutor(Autor autor) {
		return autorRep.save(autor);
	}

	public Boolean deletarAutor(Autor autor) {
		if (autor == null)
			return false;

		Autor autorExistente = buscarAutorId(autor.getCodigoAutor());
		if (autorExistente == null)
			return false;

		autorRep.delete(autor);

		Autor autorContinuaExistindo = buscarAutorId(autor.getCodigoAutor());
		if (autorContinuaExistindo == null)
			return true;

		return false;

	}

}
