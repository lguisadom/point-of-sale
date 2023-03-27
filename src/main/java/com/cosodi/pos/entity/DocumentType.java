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
@Table(name = "document_types")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DocumentType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	@Column(name = "description", unique = true, nullable = false)
	private String description;
	
	@Column(name = "short_description", nullable = false)
	private String shortDescription;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
//	private List<Customer> listCustomer;
}
