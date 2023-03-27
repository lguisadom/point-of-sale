package com.cosodi.pos.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(PurchaseDetailPK.class)
@Table(name = "purchase_details")
public class PurchaseDetail {
	@Id
	private Purchase purchase;

	@Id
	private Product product;

	@Column(nullable = false)
	private Integer units;

	@Column(name = "purchase_price", nullable = false)
	private BigDecimal purchasePrice;

	@Column(nullable = false)
	private BigDecimal discount;
}
