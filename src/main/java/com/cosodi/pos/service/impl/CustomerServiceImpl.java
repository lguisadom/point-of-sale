package com.cosodi.pos.service.impl;

import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cosodi.pos.entity.Customer;
import com.cosodi.pos.repository.ICustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends CRUDImpl<Customer, Long> implements ICustomerService {
	private final ICustomerRepository iCustomerRepository;

	@Override
	protected IGenericRepository<Customer, Long> getRepository() {
		return this.iCustomerRepository;
	}
}
