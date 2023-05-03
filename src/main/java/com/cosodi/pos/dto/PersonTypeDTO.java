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
public class PersonTypeDTO {
    @EqualsAndHashCode.Include
    private Integer id;

    @NotBlank(message = "{personType.description.notBlank}")
    @Size(min = 3, max = 100, message = "{personType.description.size}")
    private String description;

    @NotBlank(message = "{personType.shortDescription.notBlank}")
    @Size(min = 3, max = 30, message = "{personType.shortDescription.size}")
    private String shortDescription;
}
