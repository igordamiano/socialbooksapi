package com.igor.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
