package com.codeoftheweb.salvo;

import com.codeoftheweb.salvo.model.Game;
import com.codeoftheweb.salvo.model.Player;
import com.codeoftheweb.salvo.repositories.GameRepository;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository) {
		return (args) -> {
			// Players
			playerRepository.save(new Player("Jack"));
			playerRepository.save(new Player("Chloe"));
			playerRepository.save(new Player("Kim"));
			playerRepository.save(new Player("David"));
			playerRepository.save(new Player("Michelle"));

			// Games
			Game game1 = new Game(new Date());

			gameRepository.save(game1);
		};
	}
}






