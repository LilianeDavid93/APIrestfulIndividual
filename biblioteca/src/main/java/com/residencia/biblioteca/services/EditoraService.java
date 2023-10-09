package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRep;

	public List<Editora> listarEditora() {
		return editoraRep.findAll();
	}

	public Editora buscarEditoraId(Integer id) {
		return editoraRep.findById(id).get();
	}

	public Editora salvarEditora(Editora editora) {
		return editoraRep.save(editora);
	}

	public Editora atualizaEditora(Editora editora) {
		return editoraRep.save(editora);
	}

	public void deletarEditora(Editora editora) {
		editoraRep.delete(editora);
		/*
		 * Aluno confereAlunoDeletado = buscarAlunoID(aluno.getNumeroMatriculaAluno());
		 */
	}

}
