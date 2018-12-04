package com.rizaldi.steam.web.repository;

import com.rizaldi.steam.web.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Page<Game> findByNameContains(String name, Pageable pageable);
}
