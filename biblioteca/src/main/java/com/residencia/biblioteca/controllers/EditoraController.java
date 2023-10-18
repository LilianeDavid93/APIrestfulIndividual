package com.residencia.biblioteca.controllers;

import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.biblioteca.DTO.EditoraDTO;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.services.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	EditoraService editoraService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<Editora>> listarEditora() {
		return new ResponseEntity<>(editoraService.listarEditora(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora> buscarEditoraId(@PathVariable Integer id) {
		Editora editora = editoraService.buscarEditoraId(id);
		if (editora == null) {
			return new ResponseEntity<>(editora, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(editora, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<EditoraDTO> salvarEditora(@RequestBody EditoraDTO editoraDTO) throws ParseException {
		Editora entidade = convertDtoToEntity(editoraDTO);
		return new ResponseEntity<>(convertEntityToDto(editoraService.salvarEditora(entidade)), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Editora> atualizar(@RequestBody Editora editora) {
		return new ResponseEntity<>(editoraService.atualizaEditora(editora), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarEditora(@RequestBody Editora editora) {
		if (editoraService.deletarEditora(editora))
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		else
			return new ResponseEntity<>("Nao foi possivel deletar", HttpStatus.BAD_REQUEST);
	}
	
	private Editora convertDtoToEntity(EditoraDTO dto) throws ParseException {
		Editora entidade = modelMapper.map(dto, Editora.class);
		return entidade;
	}
	
	private EditoraDTO convertEntityToDto(Editora entidade) throws ParseException {
		EditoraDTO dto = modelMapper.map(entidade, EditoraDTO.class);
		return dto;
	}
}
