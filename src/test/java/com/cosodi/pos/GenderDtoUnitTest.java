package com.cosodi.pos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.cosodi.pos.dto.GenderDTO;
import com.cosodi.pos.entity.Gender;

@SpringBootTest
public class GenderDtoUnitTest {
	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void whenConvertGenderEntityToDto_thenCorrect() {
		Gender gender = new Gender();
		gender.setId(1);
		gender.setName("MASCULINO");
		
		GenderDTO genderDto = modelMapper.map(gender, GenderDTO.class);
		assertEquals(gender.getId(), genderDto.getId());
		assertEquals(gender.getName(), genderDto.getName());
	}
	
	@Test
	public void whenConvertGenderDtoToEntity_thenCorrect() {
		GenderDTO genderDto = new GenderDTO();
		genderDto.setId(1);
		genderDto.setName("FEMENINO");
		
		Gender gender = modelMapper.map(genderDto, Gender.class);
		assertEquals(genderDto.getId(), gender.getId());
		assertEquals(genderDto.getName(), gender.getName());
	}
}
