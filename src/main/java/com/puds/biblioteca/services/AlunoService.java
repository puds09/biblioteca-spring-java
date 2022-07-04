package com.puds.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puds.biblioteca.models.Aluno;
import com.puds.biblioteca.repository.AlunoRepositorio;
import com.puds.biblioteca.repository.LivroRepositorio;

@Service
public class AlunoService {

	private final AlunoRepositorio alunoRepositorio;
	private final LivroRepositorio livroRepositorio;
	private final LivroService livroService;

	@Autowired
	public AlunoService(AlunoRepositorio alunoRepositorio, LivroRepositorio livroRepositorio, LivroService livroService) {
		this.alunoRepositorio = alunoRepositorio;
		this.livroRepositorio = livroRepositorio;
		this.livroService = livroService;
	}

	public List<Aluno> getAlunos() {
		return alunoRepositorio.findAll();
	}

	public void addAluno(Aluno aluno) {
		alunoRepositorio.save(aluno);

	}

	public void removeAlunoById(int id) throws Exception {
		if (alunoRepositorio.existsById(id)) {
			alunoRepositorio.delete(alunoRepositorio.findById(id).get());
		} else {
			throw new Exception("Aluno com esse Id não existe");
		}
	}



}
