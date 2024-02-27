package com.alexc.gamerec.repositories;

import com.alexc.gamerec.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends CrudRepository<Rating, Long> {
}
