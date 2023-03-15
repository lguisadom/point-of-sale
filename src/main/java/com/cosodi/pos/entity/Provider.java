package com.cosodi.pos.entity;

import java.util.Date;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider {
	private Long id;
	private DocumentType documentType;
	private String documentNumber;
	private PersonType personType;	
	private String socialReason;
	private String commercialName;
	private String address;
	private String phoneNumber;
	private String email;
	private Long departmentId;
	private Long provinceId;
	private Long districtId;
	private Date registrationDate;
	
	@PrePersist
	public void assignRegistrationDate() {
		this.registrationDate = new Date();
	}
}
