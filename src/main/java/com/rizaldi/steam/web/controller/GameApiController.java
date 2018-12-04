package com.rizaldi.steam.web.controller;

import com.rizaldi.steam.web.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class GameApiController {
    private final GameService service;

    public GameApiController(GameService service) {
        this.service = service;
    }

    @GetMapping("delete/{id}")
    public void deleteGame(@PathVariable int id) {
        service.deleteGame(id);
    }
}
