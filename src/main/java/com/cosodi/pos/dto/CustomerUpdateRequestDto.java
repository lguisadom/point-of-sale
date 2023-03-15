package com.cosodi.pos.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerUpdateRequestDto {
	private Integer documentTypeId;
	private String documentNumber;
	private Integer personTypeId;	
	private String firstname;
	private String middlename;
	private String lastname;
	private String surname;
	private String socialReason;
	private String commercialName;
	private Date birthdate;
	private String address;
	private String phoneNumber;
	private String email;
	private Integer genderId;
	private Long departmentId;
	private Long provinceId;
	private Long districtId;	
}
