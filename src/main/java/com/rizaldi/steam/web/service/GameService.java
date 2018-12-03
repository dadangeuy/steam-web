package com.rizaldi.steam.web.service;

import com.rizaldi.steam.web.model.Game;
import com.rizaldi.steam.web.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private static final int DEFAULT_SIZE = 25;
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public Page<Game> getGamesInPage(int page) {
        return repository.findAll(PageRequest.of(page, DEFAULT_SIZE));
    }
}
