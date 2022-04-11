package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>
{

}
