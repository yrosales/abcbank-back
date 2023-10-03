package com.example.abcbank.service;

import java.util.List;

import com.example.abcbank.entity.Address;

public interface AddressService {
    List<Address> all ();
    Address add(Address address);
    Address update(Address address, Long id);
    void delete(Long id);
}
