package com.cosodi.pos.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail {
	private Long id;
	private Long saleId;
	private Long productId;
	private Integer units;
	private BigDecimal salePrice;
	private BigDecimal discount;
}
