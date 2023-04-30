package com.cosodi.pos.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GenderDTO {
	@EqualsAndHashCode.Include
	private Integer id;

	@NotEmpty(message = "Nombre no debe estar vacío")
	@Size(max = 100)
	private String name;
}
