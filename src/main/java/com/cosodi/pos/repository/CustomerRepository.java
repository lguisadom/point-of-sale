package com.cosodi.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosodi.pos.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> 	{

}
