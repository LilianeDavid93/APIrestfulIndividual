package com.residencia.biblioteca.controllers;

import java.util.List;

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

import com.residencia.biblioteca.entities.Autor;
import com.residencia.biblioteca.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorService autorService;

	@GetMapping
	public ResponseEntity<List<Autor>> listarAutor() {
		return new ResponseEntity<>(autorService.listarAutor(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> buscarAutorId(@PathVariable Integer id) {
		Autor autor = autorService.buscarAutorId(id);
		if (autor == null) {
			return new ResponseEntity<>(autor, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(autor, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Autor> salvarAutor(@RequestBody Autor autor) {
		return new ResponseEntity<>(autorService.salvarAutor(autor), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Autor> atualizarAutor(@RequestBody Autor autor) {
		return new ResponseEntity<>(autorService.atualizarAutor(autor), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarAutor(@RequestBody Autor autor) {
		if (autorService.deletarAutor(autor))
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		else
			return new ResponseEntity<>("Nao foi possivel deletar", HttpStatus.BAD_REQUEST);
	}
}
