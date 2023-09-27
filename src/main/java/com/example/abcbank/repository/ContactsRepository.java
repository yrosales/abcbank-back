package com.example.abcbank.repository;

import com.example.abcbank.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends CrudRepository<Contact, Long> {

}
