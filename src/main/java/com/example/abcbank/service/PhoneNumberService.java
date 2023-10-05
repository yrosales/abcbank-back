package com.example.abcbank.service;

import java.util.List;

import com.example.abcbank.entity.PhoneNumber;

public interface PhoneNumberService {

    List<PhoneNumber> all ();
    PhoneNumber add(PhoneNumber phoneNumber);
    void addAll(List<PhoneNumber> phoneNumbers);
    PhoneNumber update(PhoneNumber phoneNumber, Long id);
    void delete(Long id);
    void deleteAll(List<PhoneNumber> phoneNumbers);
}
