package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Tag;
import com.alexc.gamerec.services.TagServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    TagServ tagServ;

    //Read Operations
    @GetMapping("/{id}")
    public ResponseEntity<Tag> findTag(@PathVariable("id") Long id) {
        Tag tag = tagServ.getTagById(id);
        if(tag != null) {
            Tag returnTag = new Tag();
            returnTag.setId(tag.getId());
            returnTag.setName(tag.getName());
            return new ResponseEntity<>(returnTag, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //Create Operations
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return new ResponseEntity<Tag>(tagServ.createTag(tag), HttpStatus.OK);
    }

    //Update Operations
    @PostMapping("/update/{tagId}")
    @ResponseBody
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag, @PathVariable("tagId") Long id) {
        Tag updateTag = tagServ.getTagById(id);
        if(updateTag != null) {
            updateTag.setName(tag.getName());
            return new ResponseEntity<Tag>(tagServ.updateTag(updateTag), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //Delete Operations
    @GetMapping("/delete/{tagId}")
    @ResponseBody
    public ResponseEntity deleteTag(@PathVariable("tagId") Long id) {
        Tag tag = tagServ.getTagById(id);
        if(tag != null) {
            tagServ.deleteTag(tag);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
