package com.redtailsoft.springwebapp.bootstrap;

import com.redtailsoft.springwebapp.model.Author;
import com.redtailsoft.springwebapp.model.Book;
import com.redtailsoft.springwebapp.model.Publisher;
import com.redtailsoft.springwebapp.repositories.AuthorRepository;
import com.redtailsoft.springwebapp.repositories.BookRepository;
import com.redtailsoft.springwebapp.repositories.PublisherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * DevBootstrap
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    // This autowired is not necessary because it's the only constructor for this class. But
    // if there were other constructors, this is definitely necessary.
    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    
    private void initData() {
        // Create an Of Mice & Men Book and author
        Author steinbeck = new Author("John", "Steinbeck");
        Publisher p1 = new Publisher("Covici Friede", "111 Main Street", "Santa Cruz", "CA", "95034");
        Book omam = new Book("Of Mice And Men", "11234", p1);
        
        publisherRepository.save(p1);

        steinbeck.getBooks().add(omam);
        omam.getAuthors().add(steinbeck);
        authorRepository.save(steinbeck);
        bookRepository.save(omam);

        // Create Crime & Punishment
        Author a2 = new Author("Fyodor", "Dostoevsky");
        Publisher p2 = new Publisher( "The Russian Messenger", "303 Stazysky Rao", "Rustovia", "OAL", "00933434-3943");
        Book b2 = new Book("Crime and Punishment", "22334", p2);
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);

        publisherRepository.save(p2);
        authorRepository.save(a2);
        bookRepository.save(b2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

}

 