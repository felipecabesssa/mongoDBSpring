package com.br.felipesa.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.felipesa.workshopmongo.domain.User;
import com.br.felipesa.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
// REST - Serviço - Repository (DAO)
	
	public List<User> findAll(){
		return repo.findAll();		
		
	}

}
