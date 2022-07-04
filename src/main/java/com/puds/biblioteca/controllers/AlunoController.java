package com.puds.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puds.biblioteca.models.Aluno;
import com.puds.biblioteca.services.AlunoService;

@RestController
@RequestMapping(path = "api")
public class AlunoController {

//	private final LivroService livroService;	
	private final AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService /* , LivroService livroService */) {
		this.alunoService = alunoService;
//		this.livroService = livroService;
	}

	@GetMapping("/listaAlunos")
	public List<Aluno> getAlunos() {
		return this.alunoService.getAlunos();
	}

	@PostMapping("/adicionaAluno")
	public void registraAluno(@RequestBody Aluno aluno) {
		this.alunoService.addAluno(aluno);
	}

	@DeleteMapping("/deletaAluno/{id}")
	public void deletaAluno(@PathVariable("id") int id) {
		try {
			this.alunoService.removeAlunoById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
