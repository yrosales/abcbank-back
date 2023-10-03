package com.example.abcbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abcbank.entity.Address;
import com.example.abcbank.repository.AddressRepository;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> all() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void addAll(List<Address> addresses) {
        addressRepository.saveAll(addresses);
    }

    @Override
    public Address update(Address editedAddress, Long id) {
        Address address = addressRepository.findById(id).get();
        address.setAddress(editedAddress.getAddress());
        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

}
