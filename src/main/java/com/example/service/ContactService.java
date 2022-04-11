package com.example.service;

import java.util.List;

import com.example.Entity.Contact;

public interface ContactService {
	public boolean saveContact(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactById(Integer contactId);
	public boolean DeleteContactById(Integer contactId);

}
