package com.cosodi.pos.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SaleDetailDTO {
    @JsonBackReference
    @EqualsAndHashCode.Include
    private SaleDTO sale;

    @EqualsAndHashCode.Include
    private ProductDTO product;

    @NotNull
    private Integer units;

    @NotNull
    private BigDecimal salePrice;

    @NotNull
    private BigDecimal discount;
}
