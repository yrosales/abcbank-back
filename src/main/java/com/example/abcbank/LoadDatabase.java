package com.example.abcbank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.abcbank.entity.Contact;
import com.example.abcbank.repository.ContactsRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(ContactsRepository contactsRepository) {

		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Firstone", "Secondone", "Address 1", new Date(), "123123123", null));
		contacts.add(new Contact("Firsttwo", "Secondtwo", "Address 2", new Date(), "123345345", null));
		contacts.add(new Contact("Firstthree", "Secondthree", "Address 3", new Date(), "123567567", null));
		return args -> {
			for (Contact contact : contacts) {
				log.info("Preloading " + contactsRepository.save(contact));
			}

		};
	}

}
