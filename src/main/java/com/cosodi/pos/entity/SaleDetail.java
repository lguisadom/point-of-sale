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
@IdClass(SaleDetailPK.class)
@Table(name = "sale_details")
public class SaleDetail {
	@Id
	private Sale sale;

	@Id
	private Product product;

	@Column(nullable = false)
	private Integer units;

	@Column(name = "sale_price", nullable = false)
	private BigDecimal salePrice;

	@Column(nullable = false)
	private BigDecimal discount;
}
