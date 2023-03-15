package com.cosodi.pos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosodi.pos.dto.CustomerSaveRequestDto;
import com.cosodi.pos.dto.CustomerSaveResponseDto;
import com.cosodi.pos.entity.Customer;
import com.cosodi.pos.entity.Department;
import com.cosodi.pos.entity.District;
import com.cosodi.pos.entity.DocumentType;
import com.cosodi.pos.entity.Gender;
import com.cosodi.pos.entity.PersonType;
import com.cosodi.pos.entity.Province;
import com.cosodi.pos.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Customer> findById(Long id) {
		return this.customerRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		this.customerRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public CustomerSaveResponseDto save(CustomerSaveRequestDto customerDto) {
		CustomerSaveResponseDto response = new CustomerSaveResponseDto();
		
		Customer customer = new Customer();
		DocumentType documentType = new DocumentType();
		documentType.setId(customerDto.getDocumentTypeId());
		PersonType personType = new PersonType();
		personType.setId(customerDto.getPersonTypeId());
		Gender gender = new Gender();
		gender.setId(customerDto.getGenderId());
		Department department = new Department();
		department.setId(customerDto.getDepartmentId());
		Province province = new Province();
		province.setId(customerDto.getProvinceId());
		District district = new District();
		district.setId(customerDto.getDistrictId());
		customer.setDocumentType(documentType);
		customer.setDocumentNumber(customerDto.getDocumentNumber());
		customer.setPersonType(personType);
		customer.setFirstname(customerDto.getFirstname());
		customer.setMiddlename(customerDto.getMiddlename());
		customer.setLastname(customerDto.getLastname());
		customer.setSurname(customerDto.getSurname());
		customer.setSocialReason(customerDto.getSocialReason());
		customer.setCommercialName(customerDto.getCommercialName());
		customer.setBirthdate(customerDto.getBirthdate());
		customer.setAddress(customerDto.getAddress());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		customer.setEmail(customerDto.getEmail());
		customer.setGender(gender);
		customer.setDepartment(department);
		customer.setProvince(province);
		customer.setDistrict(district);
		customer = this.customerRepository.save(customer);
		
		response.setId(customer.getId());
		return response;
	}

//	@Override
//	@Transactional(readOnly = false)
//	public CustomerUpdateResponseDto update(CustomerUpdateRequestDto customerDto) {
//		
//	}
}
