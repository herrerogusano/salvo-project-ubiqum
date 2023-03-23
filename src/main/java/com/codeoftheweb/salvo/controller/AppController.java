package com.codeoftheweb.salvo.controller;
import com.codeoftheweb.salvo.model.GamePlayer;
import com.codeoftheweb.salvo.model.Player;
import com.codeoftheweb.salvo.model.Game;
import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import com.codeoftheweb.salvo.repositories.GameRepository;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:8080")

public class AppController {

    @Autowired
    public PlayerRepository playerRepository;

    @Autowired
    public GameRepository gameRepository;

    @Autowired
    public GamePlayerRepository gamePlayerRepository;

    @CrossOrigin
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }


   @CrossOrigin
   @PostMapping("/players")
   public ResponseEntity<String> createPlayer(@RequestParam String userName){
       if (userName.isEmpty()) {
           return new ResponseEntity<>("No name given", HttpStatus.FORBIDDEN);
       }

       playerRepository.save(new Player(userName));
       return new ResponseEntity<>("Name added", HttpStatus.CREATED);

   }

    @CrossOrigin
    @GetMapping("/games")
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/gameplayers")
    public List<GamePlayer> getGamePlayers() {
        return gamePlayerRepository.findAll();
    }

}

