package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRep;

	public List<Emprestimo> listarEmprestimo() {
		return emprestimoRep.findAll();
	}

	public Emprestimo buscarEmprestimoId(Integer id) {
		return emprestimoRep.findById(id).get();
	}

	public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRep.save(emprestimo);
	}

	public Emprestimo atualizaEmprestimo(Emprestimo emprestimo) {
		return emprestimoRep.save(emprestimo);
	}

	public void deletaEmprestimo(Emprestimo emprestimo) {
		emprestimoRep.delete(emprestimo);
		/*
		 * Aluno confereAlunoDeletado = buscarAlunoID(aluno.getNumeroMatriculaAluno());
		 */
	}
}
