package com.cosodi.pos.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProviderDTO {
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    private DocumentTypeDTO documentType;

    @NotBlank
    @Size(min = 8, max = 11)
    private String documentNumber;

    @NotNull
    private PersonTypeDTO personType;

    @NotBlank
    @Size(min = 3, max = 100)
    private String socialReason;

    @NotBlank
    @Size(min = 3, max = 100)
    private String commercialName;

    @NotBlank
    @Size(min = 3, max = 255)
    private String address;

    @Nullable
    @Size(min = 6, max = 100)
    private String phoneNumber;

    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    private DepartmentDTO department;

    @NotNull
    private ProvinceDTO province;

    @NotNull
    private DistrictDTO district;

    private LocalDateTime registrationDate;
}
