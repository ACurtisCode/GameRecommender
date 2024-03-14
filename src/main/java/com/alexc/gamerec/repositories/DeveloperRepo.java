package com.alexc.gamerec.repositories;

import com.alexc.gamerec.models.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepo extends CrudRepository<Developer, Long> {
}
