package com.example.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.abcbank.entity.PhoneNumber;
import com.example.abcbank.service.PhoneNumberService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PhoneNumberController {
    @Autowired
    PhoneNumberService phoneNumberService;

    @PostMapping("/phone-number")
    PhoneNumber addPhoneNumber (@RequestBody PhoneNumber phoneNumber) {
        return phoneNumberService.add(phoneNumber);
    }

    @PostMapping("/phone-number/{id}")
    PhoneNumber updatePhoneNumber (@RequestBody PhoneNumber phoneNumber,@PathVariable("id") Long id){
        return phoneNumberService.update(phoneNumber, id);
    }

    @DeleteMapping("/phone-number/{id}")
    String deletePhoneNumber(@PathVariable("id") Long id){
        phoneNumberService.delete(id);
        return "Phone number deleted";
    }
}
