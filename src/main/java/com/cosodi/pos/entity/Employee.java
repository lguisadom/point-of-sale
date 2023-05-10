package com.cosodi.pos.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	@JoinColumn(name = "person_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE_PERSON_TYPE"))
	private PersonType personType;

	@ManyToOne
	@JoinColumn(name = "document_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE_DOCUMENT_TYPE"))
	private DocumentType documentType;

	@Column(name = "document_number", unique = true, length = 11, nullable = false)
	private String documentNumber;

	@Column(nullable = false, length = 50)
	private String firstname;

	@Column(nullable = true, length = 50)
	private String middlename;

	@Column(nullable = false, length = 50)
	private String lastname;

	@Column(nullable = false, length = 50)
	private String surname;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@Column(name = "phone_number", nullable = true, length = 15)
	private String phoneNumber;

	@Column(name = "hiring_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime hiringDate;

	@ManyToOne
	@JoinColumn(name = "gender_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE_GENDER"))
	private Gender gender;

	@Column(name="birth_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private LocalDate birthdate;

	@ManyToOne
	@JoinColumn(name = "job_position", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE_JOB_POSITION"))
	private JobPosition jobPosition;

	@Column(name = "registration_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime registrationDate;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE_DEPARTMENT"))
	private Department department;

	@ManyToOne
	@JoinColumn(name = "province_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE_PROVINCE"))
	private Province province;

	@ManyToOne
	@JoinColumn(name = "district_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE_DISTRICT"))
	private District district;
	
	@PrePersist
	public void assignRegistrationDate() {
		this.registrationDate = LocalDateTime.now();
	}
}
