package com.cosodi.pos.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Long id;
	private String name;
	private String description;
	private BigDecimal salePrice;
	private BigDecimal purchasePrice;
	private Integer currentStock;
	private Integer minStock;
	private Integer maxStock;
	private Date registrationDate;
	private Provider provider;
	private Category category;
	
	@PrePersist
	public void assignRegistrationDate() {
		this.registrationDate = new Date();
	}
}
