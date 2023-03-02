package com.codeoftheweb.salvo;
import org.springframework.http.MediaType;
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

}

