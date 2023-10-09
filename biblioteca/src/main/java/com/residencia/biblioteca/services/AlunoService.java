package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository alunoRep;

	public List<Aluno> listarAlunos() {
		return alunoRep.findAll();
	}

	public Aluno buscarAlunoId(Integer id) {
		return alunoRep.findById(id).get();
	}

	public Aluno salvarAluno(Aluno aluno) {
		return alunoRep.save(aluno);
	}

	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRep.save(aluno);
	}

	public void deletarAluno(Aluno aluno) {
		alunoRep.delete(aluno);
		/*
		 * Aluno confereAlunoDeletado = buscarAlunoID(aluno.getNumeroMatriculaAluno());
		 */
	}
}
