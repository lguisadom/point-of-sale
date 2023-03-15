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
public class Purchase {
	private Long id;
	private Date purchaseDate;
	private VoucherType voucherType;
	private String voucherNumber;
	private String voucherSeries;
	private BigDecimal taxAmount;
	private Employee employee;
	private Provider provider;

	@PrePersist
	public void assignRegistrationDate() {
		this.purchaseDate = new Date();
	}
}
