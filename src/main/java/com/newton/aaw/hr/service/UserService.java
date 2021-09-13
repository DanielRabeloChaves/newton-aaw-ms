package com.newton.aaw.hr.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.newton.aaw.hr.domain.entity.User;
import com.newton.aaw.hr.domain.repository.UserRepository;
import com.newton.aaw.hr.exception.NotFoundException;

import org.springframework.stereotype.Service;

@Service                   //@Service: Para identificar essa classe como uma classe de serviços.
public class UserService {
	
		private final UserRepository userRepository;  /// ASSIM NAO PRECISA MAIS FAZER ARMAZENAMENTO EM MEMORIA
		                                              /// VAI ARMAZENAR EM UM BANCO DE DADOS  
		public UserService(UserRepository userRepository) {
			this.userRepository = userRepository;
		}
		
		// C - CRUD
		public User create(User u) { // METODO PARA SALVAR/CRIAR, RECEBENDO USER COMO PARAMETRO
			
			// Para criar seta os dois ModifieAt e CreateAt, para modificar(update seta apenas o ModifieAt)
			u.setCreateAt(LocalDateTime.now()); // pega data atual do sistema e coloca no create 
			u.setModifieAt(LocalDateTime.now()); // || (para saber exatamente quando esse usuario foi criado.)
			
			userRepository.save(u);    /// utilizando save passando a entidade u
			
			return u;	
		}
		// u - CRUD
		public User update(String id, User u) { //METODO PARA ATUALIZAR OBJETO. (ANTES DE SALVAR E ATUALIZAR VERIFICAR SE O OBJETO EXISTE. NÃO FAZ SENTIDO ATUALIZAR ALGO QUE NAO EXISTE.)
			
			// RECUPERAR PARA VALIDAR SE EXISTE
			var existing = get(id); // ANTES DE FAZER QUALQUER ATUALIZAÇÃO UTILIZA-SE O GET
			
			// ATULIZAR O OBJETO (UPDATE)
			existing.setName(u.getName());
			existing.setPassword(u.getPassword());
			existing.setEmail(u.getEmail());
			existing.setMobile(u.getMobile());
			existing.setStatus(u.getStatus());
			existing.setRole(u.getRole());
			
			
			// Para criar seta os dois ModifieAt e CreateAt, para modificar(update seta apenas o ModifieAt)
			existing.setModifieAt(LocalDateTime.now()); // || // vai atualizar a data de modificao do objeto
			
			userRepository.save(existing); // utilizando save passando o existing
			
			return existing;
		}
		// R - CRUD
		public User get(String id) { // METODO PARA RECUPERAR 
			
			var user = userRepository.findById(id); // RECUPERAR, com o findById passando o id como parametro
			
			if (user.isEmpty()) { // NÃO EXISTE TEM QUE RETORNAR ERRO 404
				throw new NotFoundException("User with ID"+ id + "not Found"); // Se nao encontrar o id no sistema vai lança erro 404 criado na classe NotFoundException
			}
			return user.get(); // RETORNAR O USUARIO O ATRIBUTO
		}
		
		// R - CRUD
		public List<User> getAll(){ // GETALL RECUPERA TODOS ELEMENTOS EXISTENTES
			
			return userRepository.findAll(); // RETORNA UMA LISTA DE TODOS ELEMENTOS EXISTENTES	 
		}
		
		// D - CRUD 
		public void delete(String id) { 
			
			// RECUPERAR PARA VALIDAR SE EXISTE
			get(id); // SE ELE EXISTIR NAO TEREMOS ERROS LANÇADOS SE NAO EXISTIR VAMOS TER UM ERRO
			
			userRepository.deleteById(id); // REMOVE O OBJETO APARTIR DO ID INFORMADO. funcaçao deleteById
		}
}
