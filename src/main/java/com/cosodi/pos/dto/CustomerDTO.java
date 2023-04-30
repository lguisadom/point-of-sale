package com.cosodi.pos.dto;

import java.util.Date;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerDTO {
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull(message = "Es requerido el tipo de documento")
	private Integer documentTypeId;

	@NotBlank
	@Size(min = 7, max = 11, message = "El número de documento debe tener entre 7 a 11 caracteres")
	private String documentNumber;

	@NotNull(message = "El tipo de persona es requerido")
	private Integer personTypeId;

	@Nullable
	@Size(min = 3, max = 50, message = "El primer nombre debe tener entre 3 y 50 caracteres")
	private String firstname;

	@Nullable
	@Size(min = 3, max = 50, message = "El segundo nombre debe tener entre 3 y 50 caracteres")
	private String middlename;

	@Nullable
	@Size(min = 3, max = 50, message = "El apellido paterno debe tener entre 3 y 50 caracteres")
	private String lastname;

	@Nullable
	@Size(min = 3, max = 50, message = "El apellido materno debe tener entre 3 y 50 caracteres")
	private String surname;

	@Nullable
	@Size(min = 3, max = 100, message = "La razón social debe tener entre 3 y 100 caracteres")
	private String socialReason;

	@Nullable
	@Size(min = 3, max = 100, message = "El nombre comercial debe tener entre 3 y 100 caracteres")
	private String commercialName;

	@Nullable
	@Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
	private Date birthdate;

	@NotBlank
	@Size(min = 3, max = 255, message = "La dirección debe tener entre 3 y 255 caracteres")
	private String address;

	@NotBlank
	@Size(min = 3, max = 15, message = "El número de teléfono debe tener entre 3 y 15 caracteres")
	private String phoneNumber;

	@NotBlank
	@Size(min = 5, max = 100, message = "El email debe tener entre 5 y 100 caracteres")
	@Email(message = "El email debe tener un formato válido")
	private String email;

	@NotNull(message = "El género es requerido")
	private Integer genderId;

	@NotNull(message = "El departamento es requerido")
	private Long departmentId;

	@NotNull(message = "La provincia es requerida")
	private Long provinceId;

	@NotNull(message = "El distrito es requerido")
	private Long districtId;

	private Date registrationDate;
}
