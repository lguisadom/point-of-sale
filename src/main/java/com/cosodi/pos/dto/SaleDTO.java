package com.cosodi.pos.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SaleDTO {
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    private VoucherTypeDTO voucherType;

    @NotBlank
    @Size(min = 5, max = 50)
    private String voucherNumber;

    @NotBlank
    @Size(min = 5, max = 50)
    private String voucherSerie;

    @NotNull
    private BigDecimal taxAmount;

    @NotNull
    private EmployeeDTO employee;

    @NotNull
    private CustomerDTO customer;

    @JsonManagedReference
    @NotNull
    private List<SaleDetailDTO> details;
}
