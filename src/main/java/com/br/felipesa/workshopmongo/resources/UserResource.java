package com.br.felipesa.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.felipesa.workshopmongo.domain.User;
import com.br.felipesa.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
// controlador rest acessa o serviço
	
	@Autowired
	private UserService service;
// que por sua vez acessa o repositório
	
//	@RequestMapping(method=RequestMethod.GET) - isso é a mesma coisa do GetMapping
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}

