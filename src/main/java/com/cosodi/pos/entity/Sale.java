package com.cosodi.pos.entity;

import java.math.BigDecimal;
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
@Table(name = "sales")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "sale_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date saleDate;

	@ManyToOne
	@JoinColumn(name = "voucher_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_VOUCHER_TYPE"))
	private VoucherType voucherType;

	@Column(name = "voucher_number", nullable = false, length = 50)
	private String voucherNumber;

	@Column(name = "voucher_serie", nullable = false, length = 50)
	private String voucherSerie;

	@Column(name = "tax_amount", nullable = false)
	private BigDecimal taxAmount;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_EMPLOYEE"))
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_CUSTOMER"))
	private Customer customer;

	@PrePersist
	public void assignRegistrationDate() {
		this.saleDate = new Date();
	}
}
