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
		return editoraRep.findById(id).orElse(null);
	}

	public Editora salvarEditora(Editora editora) {
		return editoraRep.save(editora);
	}

	public Editora atualizaEditora(Editora editora) {
		return editoraRep.save(editora);
	}

	public Boolean deletarEditora(Editora editora) {
		if (editora == null)
			return false;

		Editora editoraExistente = buscarEditoraId(editora.getCodigoEditora());
		if (editoraExistente == null)
			return false;

		editoraRep.delete(editora);

		Editora editoraContinuaExistindo = buscarEditoraId(editora.getCodigoEditora());
		if (editoraContinuaExistindo == null)
			return true;

		return false;

	}

}
