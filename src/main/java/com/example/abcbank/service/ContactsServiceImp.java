package com.example.abcbank.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.abcbank.entity.Contact;
import com.example.abcbank.repository.ContactsRepository;

@Service
public class ContactsServiceImp implements ContactsService {

	private final Logger logger = LoggerFactory.getLogger(ContactsServiceImp.class);

	@Autowired
	private ContactsRepository contactsRepository;

	@Override
	public List<Contact> fetchContactsList() {
		return (List<Contact>) contactsRepository.findAll();
	}

	@Override
	public Contact saveContact(Contact contact, MultipartFile file) {
		if (file != null) {
			byte[] filecontent = null;
			try {
				InputStream inputStream = file.getInputStream();
				if (inputStream == null) {
					logger.debug("file InputStream is null");
				}
				filecontent = IOUtils.toByteArray(inputStream);
				contact.setPersonalPhoto(filecontent);
			} catch (IOException ex) {
				logger.error("Error Saving uploaded file");
			}
			contact.setPersonalPhoto(filecontent);
		}
		return contactsRepository.save(contact);
	}

	@Override
	public Contact updateContact(Contact updContact, Long id) {
		return contactsRepository.findById(id).map(contact -> {
			contact.setFirstName(updContact.getFirstName());
			contact.setSecondName(updContact.getSecondName());
			contact.setDateOfBirth(updContact.getDateOfBirth());
			contact.setAddresses(updContact.getAddresses());
			contact.setPhoneNumbers(updContact.getPhoneNumbers());
			contact.setPersonalPhoto(updContact.getPersonalPhoto());
			return contactsRepository.save(contact);
		}).orElseGet(() -> {
			return contactsRepository.save(updContact);
		});
	}

	@Override
	public void deleteContactById(Long id) {
		contactsRepository.deleteById(id);
	}

	@Override
	public List<Contact> searchContactByName(String name) {
		List<Contact> contacts = fetchContactsList();
		List<Contact> contactsWithName = new ArrayList<>();
		for (Contact contact : contacts) {
			if (contact.getFirstName().equals(name)) {
				contactsWithName.add(contact);
			}
		}
		return contactsWithName;
	}

	@Override
	public List<Contact> searchContactByAge(int fromAge, int toAge) {
		List<Contact> contacts = fetchContactsList();
		List<Contact> contactsWithAge = new ArrayList<>();
		for (Contact contact : contacts) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(contact.getDateOfBirth());
			int contactAge = calculateAge(cal);

			if (contactAge >= fromAge && contactAge <= toAge) {
				contactsWithAge.add(contact);
			}
		}
		return contactsWithAge;
	}

	private static int calculateAge(Calendar dayOfBirth) {
		Calendar today = Calendar.getInstance();
		int diffYear = today.get(Calendar.YEAR) - dayOfBirth.get(Calendar.YEAR);
		int diffMonth = today.get(Calendar.MONTH) - dayOfBirth.get(Calendar.MONTH);
		int diffDay = today.get(Calendar.DAY_OF_MONTH) - dayOfBirth.get(Calendar.DAY_OF_MONTH);
		if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
			diffYear = diffYear - 1;
		}
		return diffYear;
	}
}
