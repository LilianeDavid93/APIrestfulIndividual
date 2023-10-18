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
		return emprestimoRep.findById(id).orElse(null);
	}

	public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRep.save(emprestimo);
	}

	public Emprestimo atualizaEmprestimo(Emprestimo emprestimo) {
		return emprestimoRep.save(emprestimo);
	}

	public Boolean deletaEmprestimo(Emprestimo emprestimo) {
		if (emprestimo == null)
			return false;

		Emprestimo editoraExistente = buscarEmprestimoId(emprestimo.getCodigoEmprestimo());
		if (editoraExistente == null)
			return false;

		emprestimoRep.delete(emprestimo);

		Emprestimo emprestimoContinuaExistindo = buscarEmprestimoId(emprestimo.getCodigoEmprestimo());
		if (emprestimoContinuaExistindo == null)
			return true;

		return false;
	}
}