package com.rizaldi.steam.web.controller;

import com.rizaldi.steam.web.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping("")
    public String viewHome() {
        return "redirect:/list/0";
    }

    @GetMapping("/list/{page}")
    public String viewListGame(Model model, @PathVariable int page) {
        var gamePage = service.getGamesInPage(page);
        model.addAttribute("currentPage", gamePage.getNumber());
        model.addAttribute("hasPrevious", gamePage.hasPrevious());
        model.addAttribute("hasNext", gamePage.hasNext());
        model.addAttribute("games", gamePage.getContent());
        return "List";
    }
}
