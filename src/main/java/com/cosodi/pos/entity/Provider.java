package com.cosodi.pos.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "providers")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	@JoinColumn(name = "document_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PROVIDER_DOCUMENT_TYPE"))
	private DocumentType documentType;

	@Column(name = "document_number", unique = true, length = 11, nullable = false)
	private String documentNumber;

	@ManyToOne
	@JoinColumn(name = "person_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PROVIDER_PERSON_TYPE"))
	private PersonType personType;

	@Column(name = "social_reason", nullable = false, length = 100)
	private String socialReason;

	@Column(name = "commercial_name", nullable = false, length = 100)
	private String commercialName;

	@Column(nullable = false, length = 255)
	private String address;

	@Column(name = "phone_number", nullable = true, length = 100)
	private String phoneNumber;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PROVIDER_DEPARTMENT"))
	private Department department;

	@ManyToOne
	@JoinColumn(name = "province_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PROVIDER_PROVINCE"))
	private Province province;

	@ManyToOne
	@JoinColumn(name = "district_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PROVIDER_DISTRICT"))
	private District district;

	@Column(name = "registration_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@PrePersist
	public void assignRegistrationDate() {
		this.registrationDate = new Date();
	}
}
