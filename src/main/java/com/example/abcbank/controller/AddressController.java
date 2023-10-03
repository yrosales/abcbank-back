package com.example.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.abcbank.entity.Address;
import com.example.abcbank.service.AddressService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/address")
    Address addAddreess (@RequestBody Address address) {
        return addressService.add(address);
    }

    @DeleteMapping("/address/{id}")
    String deletePhoneNumber(@PathVariable("id") Long id){
        addressService.delete(id);
        return "Address deleted";
    }
}