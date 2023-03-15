package com.cosodi.pos.controller;

import java.util.List;
import java.util.stream.Collectors;

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
	private IGenderService genderService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			List<GenderDto> listGenderDto = genderService.findAll()
				.stream()
				.map(gender -> {
					return convertToDto(gender);
				})
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
			return ResponseEntity.ok(genderService.findById(id));
		} catch (EntityNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Gender gender) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(genderService.save(gender));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Gender gender) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(genderService.update(id, gender));
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
		 GenderDto genderDto = new GenderDto();
		 genderDto.setId(gender.getId());
		 genderDto.setName(gender.getName());
		 return genderDto;
	}
	
	private Gender convertToEntity(GenderDto genderDto) {
		Gender gender = new Gender();
		gender.setName(genderDto.getName());
		
		if (genderDto.getId() != null) {
			gender.setId(genderDto.getId());
		}
		
		return gender;
	}
}
