package com.puds.biblioteca.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_id")
	private int livroId;
	@Column(name = "livro_nome")
	private String livroNome;
	@Column(name = "livro_autor")
	private String livroAutor;
	@Column(name = "emprestimo_data")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate emprestimoData = LocalDate.now();
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "aluno_id", updatable = true)
	public Aluno aluno;

	public Livro() {
	}

	public Livro(String livroNome, String livroAutor) {
		this.livroNome = livroNome;
		this.livroAutor = livroAutor;
	}

	public int getLivroId() {
		return livroId;
	}

	public void setLivroId(int livroId) {
		this.livroId = livroId;
	}

	public String getLivroAutor() {
		return livroAutor;
	}

	public void setLivroAutor(String livroAutor) {
		this.livroAutor = livroAutor;
	}

	public String getLivroNome() {
		return livroNome;
	}

	public void setLivroNome(String livroNome) {
		this.livroNome = livroNome;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return this.getLivroNome();
	}

	public void aluguelPeloAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void devolve() {
		this.aluno = null;
	}

	public LocalDate getEmprestimoData() {
		return emprestimoData;
	}

	public void setEmprestimoData(LocalDate emprestimoData) {
		this.emprestimoData = emprestimoData;
	}
	
}
