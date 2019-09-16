package com.redtailsoft.springwebapp.repositories;

import com.redtailsoft.springwebapp.model.Publisher;

import org.springframework.data.repository.CrudRepository;

/**
 * PublisherRepository
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    
}