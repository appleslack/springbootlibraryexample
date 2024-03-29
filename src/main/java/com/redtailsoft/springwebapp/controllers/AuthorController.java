package com.redtailsoft.springwebapp.controllers;

import com.redtailsoft.springwebapp.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AuthorController
 */
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping( "/authors")
    public String getAuthors( Model model ) {
        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}