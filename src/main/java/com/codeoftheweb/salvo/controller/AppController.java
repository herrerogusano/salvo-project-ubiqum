package com.codeoftheweb.salvo.controller;
import com.codeoftheweb.salvo.model.GamePlayer;
import com.codeoftheweb.salvo.model.Player;
import com.codeoftheweb.salvo.model.Game;
import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import com.codeoftheweb.salvo.repositories.GameRepository;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:8080")
@RequiredArgsConstructor
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

    @GetMapping("/games")
    public List<Object> getGames() {
        List<Game> games = this.gameRepository.findAll();
        return games.stream().map(this::makeMap).collect(Collectors.toList());
    }

    private Map<String, Object> makeMap(Game game) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", game.getId());
        map.put("created", game.getCreationDate());
        map.put("gamePlayers", this.makeMapOfGamePlayers(game.getGamePlayers()));
        return map;
    }

    private List<Object> makeMapOfGamePlayers(Set<GamePlayer> gamePlayers) {
        return gamePlayers.stream()
                .map(gamePlayer -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", gamePlayer.getId());
                    map.put("player", gamePlayer.getPlayer());
                    return map;
                })
                .collect(Collectors.toList());
    }

}

