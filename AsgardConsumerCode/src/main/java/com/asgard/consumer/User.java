package com.asgard.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String person_id;
	private String gender;
	private String birthdate;
	private String given_name;
	private String date_changed;
	private String middle_name;
	private String family_name;
	private String uuid;
	private String patient_id;
	private String identifier;
	private String object;
	private String test;
	private String category;

}