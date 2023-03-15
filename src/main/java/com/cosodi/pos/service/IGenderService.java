package com.cosodi.pos.service;

import java.util.List;

import com.cosodi.pos.entity.Gender;

public interface IGenderService {
	List<Gender> findAll();
	Gender findById(Integer id);
	Gender save(Gender gender);
	Gender update(Integer id, Gender gender);
	void deleteById(Integer id);
}
