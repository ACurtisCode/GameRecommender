package com.alexc.gamerec.repositories;

import com.alexc.gamerec.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends CrudRepository<Game, Long> {

}
