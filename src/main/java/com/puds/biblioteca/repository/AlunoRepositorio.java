package com.puds.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puds.biblioteca.models.Aluno;

@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Integer> {

}
