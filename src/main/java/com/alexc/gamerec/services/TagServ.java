package com.alexc.gamerec.services;

import com.alexc.gamerec.models.Tag;
import com.alexc.gamerec.repositories.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServ {
    @Autowired
    TagRepo tagRepo;

    public Tag getTagById(Long id) {
        return tagRepo.findById(id).get();
    }
}
