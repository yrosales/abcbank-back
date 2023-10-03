package com.example.abcbank.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.abcbank.entity.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber,Long>{
    
}
