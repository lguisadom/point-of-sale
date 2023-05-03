package com.cosodi.pos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DocumentTypeDTO {
    @EqualsAndHashCode.Include
    private Integer documentTypeId;

    @NotBlank(message = "{documentType.description.notBlank}")
    @Size(min = 3, max = 100, message = "{documentType.description.size}")
    // private String description;
    private String overview;

    @NotBlank(message = "{documentType.shortDescription.notBlank}")
    @Size(min = 3, max = 30, message = "{documentType.shortDescription.size}")
    // private String shortDescription
    private String shortOverview;
}
