package com.alexc.gamerec.repositories;

import com.alexc.gamerec.models.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepo extends CrudRepository<Genre, Long> {
}
