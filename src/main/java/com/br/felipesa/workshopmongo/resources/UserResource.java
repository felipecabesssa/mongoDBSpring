package com.br.felipesa.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.felipesa.workshopmongo.domain.User;
import com.br.felipesa.workshopmongo.dto.UserDTO;
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
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
//      Cnvertendo a lista para um objeto DTO para povoar ele e depois retornando ao formato lista pq nosso return é uma lista
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}

