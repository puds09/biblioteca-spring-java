package com.puds.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puds.biblioteca.models.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Integer> {

}
