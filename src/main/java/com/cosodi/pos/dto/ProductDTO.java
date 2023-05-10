package com.cosodi.pos.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductDTO {
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @Nullable
    @Size(min = 3, max = 255)
    private String description;

    private BigDecimal salePrice;

    private BigDecimal purchasePrice;

    private Integer currentStock;

    private Integer minStock;

    private Integer maxStock;

    @NotNull
    private ProviderDTO provider;

    @NotNull
    private CategoryDTO category;
}
