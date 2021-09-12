package com.newton.aaw.hr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.aaw.hr.api.UserDto;
import com.newton.aaw.hr.domain.entity.User;
import com.newton.aaw.hr.service.UserService;

@RestController
public class UserController {
	
	
	// LINKAR O CONTROLE COM SERVIÇO- ADICIONAR UMA DEPEDENCIA E CRIAR UM CONSTRUTOR
	
	// DEPEDENCIA
	private final  UserService userService;
	
	// CONSTRUTOR
	public UserController(UserService userService) { // COM ELE O FRAMEWORK CRIA O SERVIÇO E INJETAR O SERVIÇO AQUI DENTRO DA MINHA CLASSE PARA SER UTILIZDO
		this.userService = userService;
	}
	
	@GetMapping("/users/{id}") // VERBO HTTP PARA RECUPERAR. DEFINIR UMA ROTA / USER/{ID}
	public UserDto getById(@PathVariable String id) { // GET- esse @PathVariable serve para associar o parametro {id} com a variavel id
		var user =  userService.get(id);
		
		return new UserDto(user);
		
	}
	
	@GetMapping("/users")
	public List<UserDto> getAll() { // GETALL- Recebe a lista completa de usuarios
		var users = userService.getAll();
		
		var userDtos = new ArrayList<UserDto>();
		
		for (var user: users) {
			userDtos.add(new UserDto(user));
		}
		return userDtos;
	}
	
	@PostMapping("/users")
	public UserDto create(@RequestBody UserDto u) { // CRIAR-  Recebe um objeto usuario para ser salvo pela primeira vez. @RequestBody pega o Json e transforma em Dto.
		var user = new User(u); // Criar usuario
		
		user = userService.create(user);
		
		return new UserDto(user);
	}
	
	@PutMapping("/users/{id}")
	public UserDto update(@PathVariable String id, @RequestBody UserDto u) { //ATUALIZAR - Update passando id e usuario para fazer atualização
		var user = new User(u); // Criar usuario
		
		user = userService.update(id, user);
		
		return new UserDto(user);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) { // EXCLUIR - Delete passando o id para fazer a exclução
		userService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Função para devolver delete - 204
	}
}
