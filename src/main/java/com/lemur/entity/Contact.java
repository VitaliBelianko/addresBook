package com.lemur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * Created by Виталий on 30.10.2016.
 */
@Data
@AllArgsConstructor
public class Contact implements DomainObject {

	private UUID id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
}
