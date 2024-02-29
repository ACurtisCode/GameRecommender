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

    @GetMapping("/{id}")
    public Object findTag(@PathVariable("id") Long id) {
        Tag tag = tagServ.getTagById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("tagId", tag.getId());
        object.put("tagName", tag.getName());
        return object;
    }

    @PostMapping("/create")
    @ResponseBody
    public Tag createTag(@RequestBody Tag tag) {
        return tagServ.createTag(tag);
    }
}
