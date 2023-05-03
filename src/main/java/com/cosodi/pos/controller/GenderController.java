package com.cosodi.pos.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/genders")
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
public class GenderController {

	private final IGenderService iGenderService;

	@Qualifier("defaultMapper")
	private final ModelMapper modelMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	/*@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			List<GenderDTO> listGenderDTO = iGenderService.findAll()
					.stream()
					.map(this::convertToDTO)
					.collect(Collectors.toList());
			return ResponseEntity.ok(listGenderDTO);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}*/
	@GetMapping
	public ResponseEntity<List<GenderDTO>> findAll() {
		List<GenderDTO> patientDTOList = iGenderService.findAll()
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
		// return ResponseEntity.ok(listGenderDTO);
		return new ResponseEntity<>(patientDTOList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GenderDTO> findById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(this.convertToDTO(iGenderService.findById(id)), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody GenderDTO genderDTO) {
			Gender createdGender = iGenderService.save(this.convertToEntity(genderDTO));
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdGender.getId()).toUri();
			return ResponseEntity.created(location).build();
			// return ResponseEntity.status(HttpStatus.CREATED).body(this.convertToDTO(createdGender));
	}

	@PutMapping("/{id}")
	public ResponseEntity<GenderDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody GenderDTO genderDTO) {
		genderDTO.setId(id);
		Gender updatedGender = iGenderService.update(this.convertToEntity(genderDTO), id);
		// return ResponseEntity.status(HttpStatus.OK).body(this.convertToDTO(updatedGender));
		return new ResponseEntity<>(this.convertToDTO(updatedGender), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		iGenderService.deleteById(id);
		// return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	private GenderDTO convertToDTO(Gender gender) {
		 return modelMapper.map(gender, GenderDTO.class);
	}

	private Gender convertToEntity(GenderDTO genderDTO) {
		return modelMapper.map(genderDTO, Gender.class);
	}
}
