package com.example.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity(name="CONTACT_DETAILS")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	private Integer contactId;
	@Column(name="CONTACT_Name")
	private String contactName;
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	@Column(name="CREATED_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate createDate;
	@Column(name="UPDATED_DATE",insertable=false)
	@UpdateTimestamp
	private LocalDate updateDate;
	@Column(name="ACTIVE_SW")
	private String activeSw;
}
