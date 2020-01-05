package com.igor.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
