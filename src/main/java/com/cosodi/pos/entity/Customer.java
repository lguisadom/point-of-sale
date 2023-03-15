package com.cosodi.pos.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "document_type_id")
	private DocumentType documentType;
	
	@Column(name = "document_number", unique = true)
	private String documentNumber;
	
	@ManyToOne
	@JoinColumn(name = "person_type_id")
	private PersonType personType;	
	
	@Column(nullable = true)
	private String firstname;
	
	@Column(nullable = true)
	private String middlename;
	
	@Column(nullable = true)
	private String lastname;
	
	@Column(nullable = true)
	private String surname;
	
	@Column(name = "social_reason", nullable = true)
	private String socialReason;
	
	@Column(name = "commercial_name", nullable = true)
	private String commercialName;
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Column(nullable = true)
	private String address;
	
	@Column(nullable = true)
	private String phoneNumber;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "gender_id")
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "province_id")
	private Province province;
	
	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;
	
	@Column(name = "registration_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@PrePersist
	public void assignRegistrationDate() {
		this.registrationDate = new Date();
	}
}
