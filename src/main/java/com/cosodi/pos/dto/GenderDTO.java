package com.cosodi.pos.dto;

import jakarta.validation.constraints.NotEmpty;
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
	
	@NotEmpty(message = "{name.notEmpty}")
	@Size(max = 100, message = "{name.size}")
	private String name;
}
