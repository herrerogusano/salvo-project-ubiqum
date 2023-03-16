package com.codeoftheweb.salvo;

import com.codeoftheweb.salvo.model.Player;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository) {
		return (args) -> {
			// save a couple of customers
			playerRepository.save(new Player("Jack"));
			playerRepository.save(new Player("Chloe"));
			playerRepository.save(new Player("Kim"));
			playerRepository.save(new Player("David"));
			playerRepository.save(new Player("Michelle"));
		};
	}
}






