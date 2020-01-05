package com.igor.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.igor.socialbooks.domain.Comentario;
import com.igor.socialbooks.domain.Livro;
import com.igor.socialbooks.repository.ComentariosRepository;
import com.igor.socialbooks.repository.LivrosRepository;
import com.igor.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;

	public List<Livro> buscar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		
		Livro livro = livrosRepository.findById(id).orElse(null);
		
		if (livro == null) {
			throw new LivroNaoEncontradoException("O LIVRO não pôde ser encontrado.");
		}

		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null); // Garante que vai salvar um novo Livro. Se já existisse o id, faria um merge
		return livrosRepository.save(livro); // retorna livro salvo para utilizar o ID
	}
	
	public void deletar(Long id) {
		
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O LIVRO não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}

	private void verificarExistencia(Livro livro) {
		buscar(livro.getId()); // Se não achar, lança exceção LivroNaoEncontradoException do método buscar 
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId) {
		
		Livro livro = buscar(livroId);
		
		
		return livro.getComentarios();
	}
	

}
