package com.codeoftheweb.salvo.controller;
import com.codeoftheweb.salvo.model.Player;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import org.springframework.http.HttpStatus;
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
   @CrossOrigin
   @RequestMapping(name = "/players", method = RequestMethod.POST)
   public ResponseEntity<String> createPlayer(@RequestParam String userName){
       if (userName.isEmpty()) {
           return new ResponseEntity<>("No name given", HttpStatus.FORBIDDEN);
       }

       playerRepository.save(new Player(userName));
       return new ResponseEntity<>("Name added", HttpStatus.CREATED);

   }


   /*@CrossOrigin(origins="http://localhost:8080/api/players")
    @RequestMapping(name = "/players", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePlayer(@RequestParam String userName){
        if (userName.isEmpty()) {
            return new ResponseEntity<>("No name given", HttpStatus.FORBIDDEN);
        }

        playerRepository.delete();
        return new ResponseEntity<>("Named added", HttpStatus.ACCEPTED);

    }*/
}

