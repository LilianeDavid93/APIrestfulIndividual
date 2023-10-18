package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.DTO.AlunoResumidoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository alunoRep;

	public List<Aluno> listarAlunos() {
		return alunoRep.findAll();
	}
	public List<AlunoResumidoDTO> listarAlunosResumidos() {
		List<Aluno> alunos =  alunoRep.findAll();
		List<AlunoResumidoDTO> alunosDTO = new ArrayList<>();
		
		for(Aluno aluno : alunos) {
			
			alunosDTO.add(new AlunoResumidoDTO(aluno.getNumeroMatriculaAluno(),aluno.getNome(),aluno.getCpf()));

		}
		return alunosDTO;
	}

	public Aluno buscarAlunoId(Integer id) {
		return alunoRep.findById(id).orElse(null);
	}

	public AlunoResumidoDTO getAlunoResumido(Integer id) {
		Aluno aluno = alunoRep.findById(id).orElse(null);
		AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO();
		if(aluno != null) {
		alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
		alunoResDTO.setNome(aluno.getNome());
		alunoResDTO.setCpf(aluno.getCpf());
		
		}
		return alunoResDTO;
	}
			
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRep.save(aluno);
	}

	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRep.save(aluno);
	}

	public Boolean deletarAluno(Aluno aluno) {
		if (aluno == null)
			return false;

		Aluno alunoExistente = buscarAlunoId(aluno.getNumeroMatriculaAluno());
		if (alunoExistente == null)
			return false;

		alunoRep.delete(aluno);

		Aluno alunoContinuaExistindo = buscarAlunoId(aluno.getNumeroMatriculaAluno());
		if (alunoContinuaExistindo == null)
			return true;

		return false;

	}
}
