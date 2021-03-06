package com.br.felipesa.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.felipesa.workshopmongo.domain.User;
import com.br.felipesa.workshopmongo.dto.UserDTO;
import com.br.felipesa.workshopmongo.repository.UserRepository;
import com.br.felipesa.workshopmongo.services.exeption.ObjetoNaoEncontradoException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
// REST - Serviço - Repository (DAO)
	
// -------------------------------------  CRUD -----------------------------------------
	
// -------------------------------------- CREATE ---------------------------------------

	public User cria(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
// -------------------------------------  READ -----------------------------------------
	
	public List<User> acheTodos() {
		return repo.findAll();	
	}
	
// -------------------------------------- READ2 ---------------------------------------
	
	public User achePorId(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}
	
// -------------------------------------- UPDATE ---------------------------------------
	
	public User atualiza(User obj) {
		User newObj = achePorId(obj.getId());
		atualizaData(newObj, obj);
//      esse atualizaData (que vamos criar) sera responsavel por passar os dados de obj para newObj
		return repo.save(newObj);
	}
	
	
	private void atualizaData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

// -------------------------------------  DELETE -----------------------------------------
	
	public void deleta(String id) {
		achePorId(id);
		repo.deleteById(id);
	}
}
