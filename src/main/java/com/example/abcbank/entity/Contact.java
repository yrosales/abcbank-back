package com.example.abcbank.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	
	private String secondName;
	
	private String addresses;
	
	private Date dateOfBirth;
	
	private String phoneNumbers;
	
	private byte[] personalPhoto;
	
	public Contact() {
		
	}

	public Contact(String firstName, String secondName, String addresses, Date dateOfBirth, String phoneNumbers, byte[] personalPhoto) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.addresses = addresses;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumbers = phoneNumbers;
		this.personalPhoto = personalPhoto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public byte[] getPersonalPhoto() {
		return personalPhoto;
	}

	public void setPersonalPhoto(byte[] personalPhoto) {
		this.personalPhoto = personalPhoto;
	}

	@Override
	public String toString() {
		return "Contacts [firstName=" + firstName + ", addresses=" + addresses + "]";
	}
	
	
}
