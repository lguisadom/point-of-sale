package com.cosodi.pos.service.impl;

import com.cosodi.pos.repository.IGenderRepository;
import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cosodi.pos.entity.Gender;

@Service
public class GenderServiceImpl extends CRUDImpl<Gender, Integer> implements IGenderService {
	@Autowired
	private IGenderRepository iGenderRepository;

	@Override
	protected IGenericRepository<Gender, Integer> getRepository() {
		return iGenderRepository;
	}
}
