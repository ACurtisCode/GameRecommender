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

    public Tag createTag(Tag tag) {
        return tagRepo.save(tag);
    }

    public Tag createTag(String name) {
        return tagRepo.save(new Tag(name));
    }

    public Tag updateTag(Tag tag) {
        return tagRepo.save(tag);
    }

    public void deleteTag(Tag tag) {
        tagRepo.delete(tag);
    }
}
