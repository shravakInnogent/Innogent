package com.libraryManagementSystem.controller;

import com.libraryManagementSystem.entity.Author;
import com.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;



    @PostMapping("/add")
    public void add(@RequestBody Author author){
        authorService.add(author);
    }

    @GetMapping("/getAuthor/{id}")
    public Author getAuthor(@PathVariable long id){
        return authorService.getAuthor(id);
    }
}
