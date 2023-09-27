package com.example.abcbank.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.abcbank.entity.Contact;

public interface ContactsService {

	//get contact list
	List<Contact> fetchContactsList();

	//save new contact
	Contact saveContact(Contact contact, MultipartFile file);

	//update selected contact
	Contact updateContact(Contact contact, Long id);

	//delete selected contact
	void deleteContactById(Long id);
	
	//search by name
	List<Contact> searchContactByName(String Name);
	
	//search by age
	List<Contact> searchContactByAge(int fromAge, int toAge);
}
