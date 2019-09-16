package com.redtailsoft.springwebapp.controllers;

import com.redtailsoft.springwebapp.repositories.BookRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BookController
 */
@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @RequestMapping( "/books" )
    public String getBooks( Model model ) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";     // This is the view name for Spring MVC
    }

    
}