package com.cosodi.pos.service;

import java.util.List;
import java.util.Optional;

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
		Optional<Gender> optionalGender = genderRepository.findById(id);
		if (optionalGender.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		return optionalGender.get();
	}

	@Override
	public Gender save(Gender gender) {
		return genderRepository.save(gender);
	}

	@Override
	public Gender update(Integer id, Gender gender) {
		Optional<Gender> optionalGender = genderRepository.findById(id);
		if (optionalGender.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		Gender genderDB = optionalGender.get();
		genderDB.setName(gender.getName());
		return genderRepository.save(genderDB);
	}

	@Override
	public void deleteById(Integer id) {
		Optional<Gender> optionalGender = genderRepository.findById(id);
		if (optionalGender.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		genderRepository.deleteById(id);
	}

}
