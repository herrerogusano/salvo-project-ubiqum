package com.codeoftheweb.salvo.controller;
import com.codeoftheweb.salvo.model.Player;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;



@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins="http://localhost:8080")

public class AppController {

    @Autowired
    public PlayerRepository playerRepository;
    @CrossOrigin
    @GetMapping
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

   /* @CrossOrigin
    @RequestMapping(value="/api/players", method=RequestMethod.POST)

    public ResponseEntity<String> addPlayer(@RequestBody Player newPlayer) {

    }*/

}

