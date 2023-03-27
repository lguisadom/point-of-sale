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
@Table(name = "purchases")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name="purchase_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;

	@ManyToOne
	@JoinColumn(name = "voucher_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_VOUCHER_TYPE"))
	private VoucherType voucherType;

	@Column(name = "voucher_number", nullable = false, length = 50)
	private String voucherNumber;

	@Column(name = "voucher_serie", nullable = false, length = 50)
	private String voucherSerie;

	@Column(name = "tax_amount", nullable = false)
	private BigDecimal taxAmount;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_EMPLOYEE"))
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "provider_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_PROVIDER"))
	private Provider provider;

	@PrePersist
	public void assignRegistrationDate() {
		this.purchaseDate = new Date();
	}
}
