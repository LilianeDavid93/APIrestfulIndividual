package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.DTO.LivroResumidoDTO;
import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRep;

	@Autowired
	EmailService emailService;

	public List<Livro> listarLivro() {
		return livroRep.findAll();
	}

	public LivroResumidoDTO getLivroResumido(Integer id) {
		Livro livro = livroRep.findById(id).orElse(null);
		LivroResumidoDTO livroResDTO = new LivroResumidoDTO();
		if (livro != null) {
			livroResDTO.setCodigoLivro(livro.getCodigoLivro());
			;
			livroResDTO.setDataLancamento(livro.getDataLancamento());
			livroResDTO.setNomeLivro(livro.getNomeLivro());
			livroResDTO.setNomeEditora(livro.getEditora().getNome());
		}
		return livroResDTO;
	}

	public List<LivroResumidoDTO> listarLivrosResumidos() {
		List<Livro> livros = livroRep.findAll();
		List<LivroResumidoDTO> livrosDTO = new ArrayList<>();

		for (Livro livro : livros) {
			LivroResumidoDTO livroResDTO = new LivroResumidoDTO();
			livroResDTO.setCodigoLivro(livro.getCodigoLivro());
			livroResDTO.setDataLancamento(livro.getDataLancamento());
			livroResDTO.setNomeLivro(livro.getNomeLivro());
			livroResDTO.setNomeEditora(livro.getEditora().getNome());
		}
		return livrosDTO;
	}

	public Livro buscarLivroId(Integer id) {
		return livroRep.findById(id).orElse(null);
	}

	public Livro salvarLivro(Livro livro) {
		Livro newLivro = livroRep.save(livro);
		emailService.enviarEmail("lilica@gmail.com", "Novo livro cadastrado", newLivro.toString());
		return newLivro;
	}

	public Livro atualizaLivro(Livro livro) {
		return livroRep.save(livro);
	}

	public Boolean deletarLivro(Livro livro) {
		if (livro == null)
			return false;

		Livro livroExistente = buscarLivroId(livro.getCodigoLivro());
		if (livroExistente == null)
			return false;

		livroRep.delete(livro);

		Livro emprestimoContinuaExistindo = buscarLivroId(livro.getCodigoLivro());
		if (emprestimoContinuaExistindo == null)
			return true;

		return false;
	}

	@Override
	public String toString() {
		return "LivroService [livroRep=" + livroRep + ", emailService=" + emailService + "]";
	}

}
