package com.cosodi.pos.controller;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cosodi.pos.dto.GenderDTO;
import com.cosodi.pos.entity.Gender;
import com.cosodi.pos.service.IGenderService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/genders")
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
public class GenderController {

	@Qualifier("defaultMapper")
	private final ModelMapper modelMapper;

	private final IGenderService iGenderService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			List<GenderDTO> listGenderDTO = iGenderService.findAll()
					.stream()
					.map(this::convertToDto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(listGenderDTO);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		Gender gender = iGenderService.findById(id);
		GenderDTO genderDTO = this.convertToDto(gender);
		return ResponseEntity.ok(genderDTO);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody GenderDTO genderDto) {
		try {
			Gender gender = this.convertToEntity(genderDto);
			Gender genderCreated = iGenderService.save(gender);
			return ResponseEntity.status(HttpStatus.CREATED).body(this.convertToDto(genderCreated));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody GenderDTO genderDto) {
		Gender gender = this.convertToEntity(genderDto);
		Gender genderUpdated = iGenderService.update(id, gender);
		return ResponseEntity.status(HttpStatus.OK).body(this.convertToDto(genderUpdated));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		try {
			iGenderService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (EntityNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}

	private GenderDTO convertToDto(Gender gender) {
		 return modelMapper.map(gender, GenderDTO.class);
	}

	private Gender convertToEntity(GenderDTO genderDTO) {
		Gender gender = modelMapper.map(genderDTO, Gender.class);
		if (genderDTO.getId() != null) {
			gender.setId(genderDTO.getId());
		}
		
		return gender;
	}
}
