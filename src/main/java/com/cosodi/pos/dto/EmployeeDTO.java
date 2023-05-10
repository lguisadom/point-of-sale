package com.cosodi.pos.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmployeeDTO {
    @EqualsAndHashCode.Include
    private Long id;
    
    @NotNull
    private PersonTypeDTO personType;

    @NotNull
    private DocumentTypeDTO documentType;
    
    @NotBlank
    @Size(min = 8, max = 11)
    private String documentNumber;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstname;

    @Nullable
    @Size(min = 3, max = 50)
    private String middlename;

    @NotBlank
    @Size(min = 3, max = 50)
    private String lastname;

    @NotBlank
    @Size(min = 3, max = 50)
    private String surname;

    @NotBlank
    @Email
    @Size(min = 5, max = 100)
    private String email;

    @NotBlank
    @Size(min = 3, max = 15)
    private String phoneNumber;

    @NotNull
    private LocalDateTime hiringDate;

    @NotNull
    private GenderDTO gender;

    @Nullable
    @Past
    private LocalDate birthdate;

    @NotNull
    private JobPositionDTO jobPosition;

    private LocalDateTime registrationDate;

    @NotNull
    private DepartmentDTO department;

    @NotNull
    private ProvinceDTO province;

    @NotNull
    private DistrictDTO district;
}
