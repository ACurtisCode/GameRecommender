package com.alexc.gamerec.repositories;

import com.alexc.gamerec.models.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepo extends CrudRepository<Game, Long> {
    @Query("SELECT g FROM Game g WHERE g.title LIKE ?1%")
    List<Game> findGamesByTitle(String title);
}
