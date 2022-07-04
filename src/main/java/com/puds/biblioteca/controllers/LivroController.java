package com.puds.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puds.biblioteca.models.Aluno;
import com.puds.biblioteca.models.Livro;
import com.puds.biblioteca.services.LivroService;

@RestController
@RequestMapping(path = "api")
public class LivroController {

	private final LivroService livroService;

	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	@GetMapping("/listaLivros")
	public List<Livro> getLivros() {
		return this.livroService.getLivros();
	}

	@PostMapping("/adicionaLivro")
	public void registraLivro(@RequestBody Livro livro) {
		this.livroService.addLivro(livro);
	}

	@DeleteMapping("/deletaLivro/{id}")
	public void deletaLivro(@PathVariable("id") int id) {
		try {
			this.livroService.removeLivroById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@PutMapping("livro/{livroId}/aluno/{alunoId}")
	public Aluno alugaLivroPeloId(@PathVariable int livroId, @PathVariable int alunoId) {
		return livroService.alugaLivroPeloAluno(livroId, alunoId);
	}

	@DeleteMapping("livro/{livroId}/aluno/{alunoId}")
	public Aluno deletaLivroPeloId(@PathVariable int livroId, @PathVariable int alunoId) {
		return livroService.devolveLivroPeloAluno(livroId, alunoId);
	}

}
