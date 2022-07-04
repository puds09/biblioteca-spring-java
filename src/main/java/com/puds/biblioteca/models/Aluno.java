package com.puds.biblioteca.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aluno_id")
	private int alunoId;
	@Column(name = "aluno_nome")
	private String alunoNome;
	@Column(name = "aluno_telefone")
	private String alunoTelefone;

	@OneToMany()
	@JoinTable(name = "livro_alugado", joinColumns = @JoinColumn(name = "alunoId"), inverseJoinColumns = @JoinColumn(name = "livroId"))
	public List<Livro> emprestimos;

	public Aluno() {
	}

	public Aluno(String alunoNome, String alunoTelefone) {
		this.alunoNome = alunoNome;
		this.alunoTelefone = alunoTelefone;
	}

	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}

	public String getAlunoNome() {
		return alunoNome;
	}

	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}

	public String getAlunoTelefone() {
		return alunoTelefone;
	}

	public void setAlunoTelefone(String alunoTelefone) {
		this.alunoTelefone = alunoTelefone;
	}

	public List<Livro> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Livro> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public void addEmprestimos(Livro livro) {
		this.emprestimos.add(livro);
	}

	@Override
	public String toString() {
		return this.getAlunoNome();
	}

	public void popEmprestimos(Livro livro) {
		this.emprestimos.remove(livro);
	}
}
