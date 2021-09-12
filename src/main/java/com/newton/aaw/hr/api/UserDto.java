package com.newton.aaw.hr.api;

import java.time.LocalDateTime;

import com.newton.aaw.hr.domain.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

                                   //Lombok: Vai automaticamente inserir essas estruturas em cima da classe em tempo de compilação.
@Getter                           //@Getter: Adiciona métodos assessores para os atributos id, name e password.
@Setter                           //@Settert: Adiciona métodos modificadores para os atributos id, name e password.
@AllArgsConstructor               //@AllArgsConstructor: Cria um construtor na classe com todos os argumentos id, name, password.
@NoArgsConstructor                //@NoArgsConstructor: Cria um construtor sem argumento algum.
public class UserDto {
	
	private String id; 
	private String name;
	private String password;
	private String email;
	private String mobile;
	private LocalDateTime createAt; // Variavel para saber a data de quando o User vai ser criado
	private LocalDateTime modifieAt; // Variavel para saber a data de quando o User vai ser criado
	
	// Construtor Entidade para DTO
	public UserDto(User u) {
		this.id = u.getId();
		this.name = u.getName();
		this.password = u.getPassword();
		this.email = u.getEmail();
		this.mobile = u.getMobile();
		this.createAt = u.getCreateAt();
		this.modifieAt = u.getModifieAt();
	}
	
}
