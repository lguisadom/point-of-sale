package com.cosodi.pos.controller;

import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosodi.pos.dto.CustomerSaveRequestDto;
import com.cosodi.pos.dto.CustomerSaveResponseDto;
import com.cosodi.pos.entity.Customer;
import com.cosodi.pos.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(customerService.findAll());
		} catch (Exception e) {
			String message = e.getMessage();
			LOGGER.error(message, e);
			return ResponseEntity.internalServerError().body(Collections.singletonMap("message", message));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			Optional<Customer> optionalCustomer = customerService.findById(id);
			if (optionalCustomer.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(optionalCustomer.get());
			
		} catch (Exception e) {
			String message = e.getMessage();
			LOGGER.error(message, e);
			return ResponseEntity.internalServerError().body(Collections.singletonMap("message", message));
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody CustomerSaveRequestDto customerDto) {
		try {
			
			CustomerSaveResponseDto customerResponseDto = customerService.save(customerDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDto);
			
		} catch (Exception e) {
			String message = e.getMessage();
			LOGGER.error(message, e);
			return ResponseEntity.internalServerError().body(Collections.singletonMap("message", message));
		}
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody CustomerUpdateRequestDto customerDto) {
//		try {
//			Optional<Customer> optionalCustomer = customerService.findById(id);
//			if (optionalCustomer.isEmpty()) {
//				return ResponseEntity.notFound().build();
//			}
//			
//			Customer customerDB = optionalCustomer.get();
//			DocumentType documentType = new DocumentType();
//			documentType.setId(customerDto.getDocumentTypeId());
//			PersonType personType = new PersonType();
//			personType.setId(customerDto.getPersonTypeId());
//			Gender gender = new Gender();
//			gender.setId(customerDto.getGenderId());
//			Department department = new Department();
//			department.setId(customerDto.getDepartmentId());
//			Province province = new Province();
//			province.setId(customerDto.getProvinceId());
//			District district = new District();
//			district.setId(customerDto.getDistrictId());
//			customerDB.setDocumentType(documentType);
//			customerDB.setDocumentNumber(customerDto.getDocumentNumber());
//			customerDB.setPersonType(personType);
//			customerDB.setFirstname(customerDto.getFirstname());
//			customerDB.setMiddlename(customerDto.getMiddlename());
//			customerDB.setLastname(customerDto.getLastname());
//			customerDB.setSurname(customerDto.getSurname());
//			customerDB.setSocialReason(customerDto.getSocialReason());
//			customerDB.setCommercialName(customerDto.getCommercialName());
//			customerDB.setBirthdate(customerDto.getBirthdate());
//			customerDB.setAddress(customerDto.getAddress());
//			customerDB.setPhoneNumber(customerDto.getPhoneNumber());
//			customerDB.setEmail(customerDto.getEmail());
//			customerDB.setGender(gender);
//			customerDB.setDepartment(department);
//			customerDB.setProvince(province);
//			customerDB.setDistrict(district);
//			return ResponseEntity.ok(customerService.save(customerDB));
//			
//		} catch (Exception e) {
//			String message = e.getMessage();
//			LOGGER.error(message, e);
//			return ResponseEntity.internalServerError().body(Collections.singletonMap("message", message));
//		}		
//	}
}
