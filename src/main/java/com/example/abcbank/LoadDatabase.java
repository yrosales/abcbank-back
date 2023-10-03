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

import com.example.abcbank.entity.Address;
import com.example.abcbank.entity.Contact;
import com.example.abcbank.entity.PhoneNumber;
import com.example.abcbank.repository.AddressRepository;
import com.example.abcbank.repository.ContactsRepository;
import com.example.abcbank.repository.PhoneNumberRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(ContactsRepository contactsRepository, PhoneNumberRepository phoneNumberRepository,
			AddressRepository addressRepository) {

		List<Contact> contacts = new ArrayList<Contact>();
		List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
		List<Address> addresses = new ArrayList<Address>();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			contacts.add(
					new Contact("Firstone", "Secondone", format.parse("01/01/2000"), null));
			contacts.add(
					new Contact("Firsttwo", "Secondtwo", format.parse("01/05/2010"), null));
			contacts.add(new Contact("Firstthree", "Secondthree", format.parse("01/03/2015"), null));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		phoneNumbers.add(new PhoneNumber("123123123", contacts.get(0)));
		phoneNumbers.add(new PhoneNumber("345345345", contacts.get(0)));
		phoneNumbers.add(new PhoneNumber("265265265", contacts.get(0)));

		addresses.add(new Address("this is the 1st address", contacts.get(0)));
		addresses.add(new Address("this is the 2nd address", contacts.get(0)));

		return args -> {
			for (Contact contact : contacts) {
				log.info("Preloading " + contactsRepository.save(contact));
			}

			for (PhoneNumber phoneNumber : phoneNumbers) {
				log.info("Preloading " + phoneNumberRepository.save(phoneNumber));
			}

			for (Address address : addresses) {
				log.info("Preloading " + addressRepository.save(address));
			}
		};
	}

}
