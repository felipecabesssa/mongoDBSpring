package com.br.felipesa.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

// ---------------------------------- Lista todos -----------------------------------------------------
	
//	@RequestMapping(method=RequestMethod.GET) - isso é a mesma coisa do GetMapping
	@GetMapping
	public ResponseEntity<List<UserDTO>> acheTodos() {
		List<User> list = service.acheTodos();
//      Cnvertendo a lista para um objeto DTO para povoar ele e depois retornando ao formato lista pq nosso return é uma lista
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
// ---------------------------------- Lista um por id ---------------------------------------------------
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> achePorId(@PathVariable String id){
// 		A @PathVariable fala que esse id passado como argumento tem que ser igual ao id recebido na URL (value="/{id})	
		User obj = service.achePorId(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

}
















