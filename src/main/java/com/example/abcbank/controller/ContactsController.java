package com.example.abcbank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.abcbank.entity.Contact;
import com.example.abcbank.service.ContactsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactsController {

	@Autowired
	private ContactsService contactsService;

	@GetMapping("/contacts")
	public List<Contact> fetchContactsList() {
		return contactsService.fetchContactsList();
	}

	@GetMapping("/contacts/{name}")
	public List<Contact> fetchContactsList(@PathVariable Optional<String> name) {
		if (name.isPresent()) {
			return contactsService.searchContactByName(name.get());
		}
		return contactsService.fetchContactsList();
	}
	
	@GetMapping("/contacts/{fromAge}/{toAge}")
	public List<Contact> fetchContactsList(@PathVariable Optional<Integer> fromAge, @PathVariable Optional<Integer> toAge) {
		if (fromAge.isPresent() && toAge.isPresent()) {
			return contactsService.searchContactByAge(fromAge.get(),toAge.get());
		}
		return contactsService.fetchContactsList();
	}

	@PostMapping("/contacts")
	public Contact saveDrone(@RequestBody Contact contact,  @RequestParam(value="file", required=false) MultipartFile file) {
		return contactsService.saveContact(contact, file);
	}

	@PutMapping("/contacts/{id}")
	public Contact updateContact(@RequestBody Contact contact, @PathVariable("id") Long id) {
		return contactsService.updateContact(contact, id);
	}

	@DeleteMapping("/contacts/{id}")
	public String deleteContactById(@PathVariable("id") Long id) {
		contactsService.deleteContactById(id);
		return "Deleted Successfully";
	}
}
