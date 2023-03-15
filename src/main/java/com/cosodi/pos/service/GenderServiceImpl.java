package com.cosodi.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosodi.pos.entity.Gender;
import com.cosodi.pos.repository.GenderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GenderServiceImpl implements IGenderService {

	@Autowired
	private GenderRepository genderRepository;
	
	@Override
	public List<Gender> findAll() {
		return genderRepository.findAll();
	}

	@Override
	public Gender findById(Integer id) {
		return genderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public Gender save(Gender gender) {
		return genderRepository.save(gender);
	}

	@Override
	public Gender update(Integer id, Gender gender) {		
		Gender genderDB = genderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		genderDB.setName(gender.getName());
		return genderRepository.save(genderDB);
	}

	@Override
	public void deleteById(Integer id) {
		Gender genderDB = genderRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException());
		genderRepository.delete(genderDB);
	}

}
