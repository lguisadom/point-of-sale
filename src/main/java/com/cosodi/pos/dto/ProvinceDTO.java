package com.cosodi.pos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProvinceDTO {
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "{province.description.notBlank}")
    @Size(min = 3, max = 100, message = "{province.description.size}")
    private String description;
}
