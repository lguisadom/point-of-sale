package com.cosodi.pos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person_types")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(unique = true, nullable = false, length = 100)
	private String description;
	
	@Column(name = "short_description", unique = true, nullable = false, length = 30)
	private String shortDescription;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personType")
//	private List<Customer> listCustomer;
}
