package com.cosodi.pos.service;

import java.util.List;
import java.util.Optional;

import com.cosodi.pos.dto.CustomerSaveRequestDto;
import com.cosodi.pos.dto.CustomerSaveResponseDto;
import com.cosodi.pos.entity.Customer;

public interface ICustomerService {
	List<Customer> findAll();
	Optional<Customer> findById(Long id);
	CustomerSaveResponseDto save(CustomerSaveRequestDto customerDto);
	// CustomerUpdateResponseDto update(CustomerUpdateRequestDto customerDto);
	void deleteById(Long id);
}
