package com.puds.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puds.biblioteca.models.Aluno;
import com.puds.biblioteca.models.Livro;
import com.puds.biblioteca.repository.AlunoRepositorio;
import com.puds.biblioteca.repository.LivroRepositorio;

@Service
public class LivroService {

	@Autowired
	private final LivroRepositorio livroRepositorio;
	@Autowired
	private final AlunoRepositorio alunoRepositorio;

	@Autowired
	public LivroService(LivroRepositorio livroRepositorio, AlunoRepositorio alunoRepositorio) {
		this.livroRepositorio = livroRepositorio;
		this.alunoRepositorio = alunoRepositorio;
	}

	public List<Livro> getLivros() {
		return livroRepositorio.findAll();
	}

	public void addLivro(Livro livro) {
		livroRepositorio.save(livro);
	}

	public void removeLivroById(int id) throws Exception {
		if (livroRepositorio.existsById(id)) {
			livroRepositorio.delete(livroRepositorio.findById(id).get());
		} else {
			throw new Exception("Livro com esse Id não existe");
		}
	}

	public Livro findBy(String livro_nome) {
		List<Livro> livros = livroRepositorio.findAll();
		for (Livro livro : livros) {
			System.out.println(livro.toString());
			if (livro.getLivroNome() == livro_nome)
				return livro;
		}
		return null;
	}

	public Aluno alugaLivroPeloAluno(int livroId, int alunoId) {
		Livro livro = livroRepositorio.findById(livroId).get();
		Aluno aluno = alunoRepositorio.findById(alunoId).get();

		livro.aluguelPeloAluno(aluno);
		aluno.addEmprestimos(livro);
		livroRepositorio.save(livro);
		return alunoRepositorio.save(aluno);

	}

	public Aluno devolveLivroPeloAluno(int livroId, int alunoId) {
		Livro livro = livroRepositorio.findById(livroId).get();
		Aluno aluno = alunoRepositorio.findById(alunoId).get();

		livro.devolve();
		aluno.popEmprestimos(livro);
		livroRepositorio.save(livro);
		return alunoRepositorio.save(aluno);
	}

}
