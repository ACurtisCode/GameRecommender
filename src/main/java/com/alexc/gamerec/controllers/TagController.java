package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Tag;
import com.alexc.gamerec.services.TagServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    TagServ tagServ;

    //Read Operations
    @GetMapping("/{id}")
    public Object findTag(@PathVariable("id") Long id) {
        Tag tag = tagServ.getTagById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("tagId", tag.getId());
        object.put("tagName", tag.getName());
        return object;
    }

    //Create Operations
    @PostMapping("/create")
    @ResponseBody
    public Tag createTag(@RequestBody Tag tag) {
        return tagServ.createTag(tag);
    }

    //Update Operations
    @PostMapping("/update/{tagId}")
    @ResponseBody
    public Tag updateTag(@RequestBody Tag tag, @PathVariable("tagId") Long id) {
        Tag updateTag = tagServ.getTagById(id);
        updateTag.setName(tag.getName());
        return tagServ.updateTag(updateTag);
    }

    //Delete Operations
    @GetMapping("/delete/{tagId}")
    public void deleteTag(@PathVariable("tagId") Long id) {
        tagServ.deleteTag(tagServ.getTagById(id));
    }
}
