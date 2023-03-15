package com.cosodi.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosodi.pos.entity.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
