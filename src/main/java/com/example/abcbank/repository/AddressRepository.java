package com.example.abcbank.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.abcbank.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{
    
}
