package com.redtailsoft.springwebapp.repositories;

import com.redtailsoft.springwebapp.model.Author;

import org.springframework.data.repository.CrudRepository;

/**
 * AuthorRepository
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

    
}
