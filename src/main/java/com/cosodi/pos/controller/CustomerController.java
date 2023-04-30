package com.cosodi.pos.controller;

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
				.map(customer -> this.modelMapper.map(customer, CustomerDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(customerDTOList, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Long id) {
		Customer customer = this.iCustomerService.findById(id);
		CustomerDTO customerDTO = this.modelMapper.map(customer, CustomerDTO.class);
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO customerDTO) {
		Customer customer = this.modelMapper.map(customerDTO, Customer.class);
		Customer createdCustomer = this.iCustomerService.save(customer);
		return new ResponseEntity<>(this.modelMapper.map(createdCustomer, CustomerDTO.class), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> update(@PathVariable("id") Long id, @Valid @RequestBody CustomerDTO customerDTO) {
		customerDTO.setId(id);
		Customer customer = this.modelMapper.map(customerDTO, Customer.class);
		Customer updatedCustomer = this.iCustomerService.update(customer, id);
		return new ResponseEntity<>(this.modelMapper.map(updatedCustomer, CustomerDTO.class), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
		this.iCustomerService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
