package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRep;

	public List<Livro> listarLivro() {
		return livroRep.findAll();
	}

	public Livro buscarLivroId(Integer id) {
		return livroRep.findById(id).get();
	}

	public Livro salvarLivro(Livro livro) {
		return livroRep.save(livro);
	}

	public Livro atualizaLivro(Livro livro) {
		return livroRep.save(livro);
	}

	public void deletarLivro(Livro livro) {
		livroRep.delete(livro);
		/*
		 * Aluno confereAlunoDeletado = buscarAlunoID(aluno.getNumeroMatriculaAluno());
		 */
	}

}
