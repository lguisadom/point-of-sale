package com.cosodi.pos.entity;

import java.util.Date;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Long id;
	private PersonType personType;
	private DocumentType documentType;
	private String documentNumber;
	private String firstname;
	private String middlename;
	private String lastname;
	private String surname;
	private String email;
	private String phoneNumber;
	private Date hiringDate;
	private Gender gender;
	private Date birthdate;
	private Date registrationDate;	
	private Long departmentId;
	private Long provinceId;
	private Long districtId;
	
	@PrePersist
	public void assignRegistrationDate() {
		this.registrationDate = new Date();
	}
}
