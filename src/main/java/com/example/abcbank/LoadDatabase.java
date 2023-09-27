package com.example.abcbank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			contacts.add(new Contact("Firstone", "Secondone", "Address 1", format.parse("01/01/2000"), "123123123", null));
			contacts.add(new Contact("Firsttwo", "Secondtwo", "Address 2", format.parse("01/05/2010"), "123345345", null));
			contacts.add(new Contact("Firstthree", "Secondthree", "Address 3", format.parse("01/03/2015"), "123567567", null));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return args -> {
			for (Contact contact : contacts) {
				log.info("Preloading " + contactsRepository.save(contact));
			}

		};
	}

}
