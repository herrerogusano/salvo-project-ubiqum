package com.codeoftheweb.salvo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@CrossOrigin(origins="http://localhost:8080")

@RestController

public class AppController {

    @Autowired
    private PlayerRepository playerRepository;
    @RequestMapping(value = "/players")
    public List<Player> getAll() {
        System.out.println("succaaaaaaaaaaaaa");
        return playerRepository.findAll();
    }

}

