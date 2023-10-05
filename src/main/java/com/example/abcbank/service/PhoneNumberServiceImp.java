package com.example.abcbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abcbank.entity.PhoneNumber;
import com.example.abcbank.repository.PhoneNumberRepository;

@Service
public class PhoneNumberServiceImp implements PhoneNumberService{

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Override
    public List<PhoneNumber> all() {
        return (List<PhoneNumber>) phoneNumberRepository.findAll();
    }

    @Override
    public PhoneNumber add(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public void addAll(List<PhoneNumber> phoneNumbers) {
        phoneNumberRepository.saveAll(phoneNumbers);
    }

    @Override
    public PhoneNumber update(PhoneNumber editedPhoneNumber, Long id) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id).get();
        phoneNumber.setNumber(editedPhoneNumber.getNumber());
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public void delete(Long id) {
        phoneNumberRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<PhoneNumber> phoneNumbers) {
        phoneNumberRepository.deleteAll(phoneNumbers);
    }

}
