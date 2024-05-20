package com.example.springsecuritybasics.repository;

import com.example.springsecuritybasics.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {
}
