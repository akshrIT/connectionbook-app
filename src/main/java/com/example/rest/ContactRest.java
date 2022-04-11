package com.example.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Contact;
import com.example.constants.AppConstant;
import com.example.props.AppProperties;
import com.example.service.ContactService;

@RestController
@CrossOrigin
public class ContactRest {
	@Autowired
	private ContactService service;
	
	@Autowired
	private AppProperties appProps;
	
	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact)
	{
		boolean status=service.saveContact(contact);
		Map<String,String> messages=appProps.getMessages();
		
		if(status)
		{
			return messages.get(AppConstant.CONTACT_SAVE_SUCC);
		}
		else {
			return messages.get(AppConstant.CONTACT_SAVE_FAIL);
		}
	}
	
	@GetMapping("/contacts")
	public List<Contact> getAllContact(){
		
		return service.getAllContacts();
	}
	
	@GetMapping("/contact/{cid}")
	public Contact editContact(@PathVariable("cid") Integer contactId)
	{
		return service.getContactById(contactId);
	}
	
	@DeleteMapping("/contact/{cid}")
	public String deleteContact(@PathVariable("cid")Integer contactId)
	{
		boolean status =service.DeleteContactById(contactId);
		Map<String,String> messages=appProps.getMessages();
		if(status)
		{
			return messages.get(AppConstant.CONTACT_DEL_SUCC);
		}
		else {
			return messages.get(AppConstant.CONTACT_DEL_FAIL);
		}
	}

}
