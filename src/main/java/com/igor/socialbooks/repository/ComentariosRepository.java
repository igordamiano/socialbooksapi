package com.igor.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
