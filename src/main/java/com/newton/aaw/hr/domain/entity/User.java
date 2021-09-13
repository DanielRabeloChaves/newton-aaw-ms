package com.newton.aaw.hr.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.newton.aaw.hr.api.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok: Vai automaticamente inserir essas estruturas em cima da classe em tempo de compilação.
@Getter                           //@Getter: Adiciona métodos assessores para os atributos id, name e password.
@Setter                           //@Settert: Adiciona métodos modificadores para os atributos id, name e password.
@AllArgsConstructor               //@AllArgsConstructor: Cria um construtor na classe com todos os argumentos id, name, password.
@NoArgsConstructor                //@NoArgsConstructor: Cria um construtor sem argumento algum.
public class User {
	
	@Id    //Assim o MongoDb consegue saber qual é a chave primaria a ser usada.
	private String id; 
	
	private String name;
	private String password;
	private String email;
	private String mobile;
	private LocalDateTime createAt; // Variavel para saber a data de quando o User vai ser criado
	private LocalDateTime modifieAt; // Variavel para saber a data de quando o User vai ser criado
	
	private String status;          // LAB 3
	private String role;           // LAB 3
	
	public User(UserDto userDto) { // Construtor passando Dto como parametro
		this.id = userDto.getId();
		this.name = userDto.getName();
		this.password = userDto.getPassword();
		this.email = userDto.getEmail();
		this.mobile = userDto.getMobile();
		this.status = userDto.getStatus();
		this.role = userDto.getRole();
	}
}
