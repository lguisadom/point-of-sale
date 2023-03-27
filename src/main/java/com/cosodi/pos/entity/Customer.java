package com.cosodi.pos.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "document_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_DOCUMENT_TYPE"))
	private DocumentType documentType;
	
	@Column(name = "document_number", unique = true, length = 11, nullable = false)
	private String documentNumber;
	
	@ManyToOne
	@JoinColumn(name = "person_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_PERSON_TYPE"))
	private PersonType personType;	
	
	@Column(nullable = true, length = 50)
	private String firstname;
	
	@Column(nullable = true, length = 50)
	private String middlename;
	
	@Column(nullable = true, length = 50)
	private String lastname;
	
	@Column(nullable = true, length = 50)
	private String surname;
	
	@Column(name = "social_reason", nullable = true, length = 100)
	private String socialReason;
	
	@Column(name = "commercial_name", nullable = true, length = 100)
	private String commercialName;
	
	@Column(name="birth_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Column(nullable = false, length = 255)
	private String address;

	@Column(name = "phone_number", nullable = true, length = 100)
	private String phoneNumber;
	
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "gender_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_GENDER"))
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_DEPARTMENT"))
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "province_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_PROVINCE"))
	private Province province;
	
	@ManyToOne
	@JoinColumn(name = "district_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_DISTRICT"))
	private District district;
	
	@Column(name = "registration_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@PrePersist
	public void assignRegistrationDate() {
		this.registrationDate = new Date();
	}
}
