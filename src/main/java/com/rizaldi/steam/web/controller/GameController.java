package com.rizaldi.steam.web.controller;

import com.rizaldi.steam.web.model.Game;
import com.rizaldi.steam.web.service.GameService;
import org.springframework.data.domain.Page;
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
    public String home() {
        return "redirect:/list/0";
    }

    @GetMapping("list/{page}")
    public String listGame(Model model, @PathVariable int page) {
        var gamePage = service.getGamesInPage(page);
        insertGamePageIntoModel(gamePage, model);
        return "List";
    }

    @GetMapping("add")
    public String addGame() {
        return "Add";
    }

    @GetMapping("edit/{id}")
    public String editGame(Model model, @PathVariable int id) {
        var game = service.getGame(id).orElseThrow();
        model.addAttribute("game", game);
        return "Edit";
    }

    @GetMapping("find/{name}/{page}")
    public String findNameGame(Model model, @PathVariable String name, @PathVariable int page) {
        var gamePage = service.findGamesInPage(name, page);
        insertGamePageIntoModel(gamePage, model);
        model.addAttribute("name", name);
        return "FindName";
    }

    private void insertGamePageIntoModel(Page<Game> gamePage, Model model) {
        model.addAttribute("currentPage", gamePage.getNumber());
        model.addAttribute("hasPrevious", gamePage.hasPrevious());
        model.addAttribute("hasNext", gamePage.hasNext());
        model.addAttribute("games", gamePage.getContent());
    }
}
