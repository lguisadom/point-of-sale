package com.cosodi.pos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosodi.pos.dto.GenderDto;
import com.cosodi.pos.entity.Gender;
import com.cosodi.pos.service.IGenderService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/gender")
public class GenderController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IGenderService genderService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			List<GenderDto> listGenderDto = genderService.findAll()
				.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
			return ResponseEntity.ok(listGenderDto);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		try {
			Gender gender = genderService.findById(id);
			GenderDto genderDto = this.convertToDto(gender);
			return ResponseEntity.ok(genderDto);
		} catch (EntityNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody GenderDto genderDto) {
		try {
			Gender gender = this.convertToEntity(genderDto);
			Gender genderCreated = genderService.save(gender);
			return ResponseEntity.status(HttpStatus.CREATED).body(this.convertToDto(genderCreated));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody GenderDto genderDto) {
		try {
			Gender gender = this.convertToEntity(genderDto);
			Gender genderUpdated = genderService.update(id, gender);
			return ResponseEntity.status(HttpStatus.OK).body(this.convertToDto(genderUpdated));
		} catch (EntityNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		try {
			genderService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (EntityNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}		
	}
	
	private GenderDto convertToDto(Gender gender) {
		 GenderDto genderDto = modelMapper.map(gender, GenderDto.class);
		 return genderDto;
	}
	
	private Gender convertToEntity(GenderDto genderDto) {
		Gender gender = modelMapper.map(genderDto, Gender.class);
		if (genderDto.getId() != null) {
			gender.setId(genderDto.getId());
		}
		
		return gender;
	}
}
