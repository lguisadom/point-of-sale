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

import com.cosodi.pos.dto.CustomerDTO;
import com.cosodi.pos.entity.Customer;
import com.cosodi.pos.service.ICustomerService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
	private final ICustomerService iCustomerService;

	@Qualifier("defaultMapper")
	private final ModelMapper modelMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<CustomerDTO> customerDTOList = this.iCustomerService.findAll()
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
		return new ResponseEntity<>(customerDTOList, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(this.convertToDTO(this.iCustomerService.findById(id)), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO customerDTO) {
		Customer createdCustomer = this.iCustomerService.save(this.convertToEntity(customerDTO));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCustomer.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> update(@PathVariable("id") Long id, @Valid @RequestBody CustomerDTO customerDTO) {
		customerDTO.setId(id);
		return new ResponseEntity<>(this.convertToDTO(
				this.iCustomerService.update(this.convertToEntity(customerDTO), id)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
		this.iCustomerService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	private Customer convertToEntity(CustomerDTO customerDTO) {
		return this.modelMapper.map(customerDTO, Customer.class);
	}

	private CustomerDTO convertToDTO(Customer customer) {
		return this.modelMapper.map(customer, CustomerDTO.class);
	}
}
