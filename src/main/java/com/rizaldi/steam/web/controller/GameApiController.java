package com.rizaldi.steam.web.controller;

import com.rizaldi.steam.web.model.Game;
import com.rizaldi.steam.web.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class GameApiController {
    private final GameService service;

    public GameApiController(GameService service) {
        this.service = service;
    }

    @PostMapping("save")
    public Game saveGame(@ModelAttribute Game game) {
        return service.saveGame(game);
    }

    @GetMapping("delete/{id}")
    public void deleteGame(@PathVariable int id) {
        service.deleteGame(id);
    }
}
