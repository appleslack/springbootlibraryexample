package com.redtailsoft.springwebapp.repositories;

import com.redtailsoft.springwebapp.model.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * BookRepository
 */
@Component
 public interface BookRepository extends CrudRepository<Book, Long> {

    
}