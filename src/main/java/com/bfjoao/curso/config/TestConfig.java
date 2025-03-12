package com.bfjoao.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bfjoao.curso.entidades.User;
import com.bfjoao.curso.repositories.UserRepository;

@Configuration // Indica que esta classe contém configurações para a aplicação.
@Profile("test") // Define que essa configuração só será ativada quando o perfil "test" estiver ativo no application.properties.
public class TestConfig implements CommandLineRunner { //  permite executar um código automaticamente assim que a aplicação Spring Boot for iniciada.

	@Autowired // O Spring injeta automaticamente a instância do UserRepository para interagir com o banco de dados.
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
