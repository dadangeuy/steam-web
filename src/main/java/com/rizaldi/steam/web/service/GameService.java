package com.rizaldi.steam.web.service;

import com.rizaldi.steam.web.model.Game;
import com.rizaldi.steam.web.repository.GameRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CacheConfig(cacheNames = "games")
public class GameService {
    private static final int DEFAULT_SIZE = 25;
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    @Cacheable(key = "'page@' + #page", sync = true)
    public Page<Game> getGamesInPage(int page) {
        return repository.findAll(PageRequest.of(page, DEFAULT_SIZE));
    }

    @Cacheable(key = "'id@' + #id", sync = true)
    public Optional<Game> getGame(int id) {
        return repository.findById(id);
    }

    @Cacheable(key = "'find-name@' + #name + '-page@' + #page", sync = true)
    public Page<Game> findGamesInPage(String name, int page) {
        return repository.findByNameContains(name, PageRequest.of(page, DEFAULT_SIZE));
    }

    @CachePut(key = "'id@' + #game.id")
    public Game saveGame(Game game) {
        return repository.save(game);
    }

    @CacheEvict(key = "'id@' + #id")
    public void deleteGame(int id) {
        repository.deleteById(id);
    }
}
