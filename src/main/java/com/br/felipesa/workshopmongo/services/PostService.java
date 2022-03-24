package com.br.felipesa.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.felipesa.workshopmongo.domain.Post;
import com.br.felipesa.workshopmongo.repository.PostRepository;
import com.br.felipesa.workshopmongo.services.exeption.ObjetoNaoEncontradoException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post achePorId(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}

}
