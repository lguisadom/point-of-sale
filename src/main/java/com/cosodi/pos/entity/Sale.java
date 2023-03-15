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
public class Sale {
	private Long id;
	private Date saleDate;
	private VoucherType voucherType;
	private String voucherNumber;
	private String voucherSeries;
	private BigDecimal taxAmount;
	private Employee employee;
	private Customer customer;
	
	@PrePersist
	public void assignRegistrationDate() {
		this.saleDate = new Date();
	}
}
