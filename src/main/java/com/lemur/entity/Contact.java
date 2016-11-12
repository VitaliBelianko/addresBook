package com.lemur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by Виталий on 30.10.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements DomainObject {

	private UUID id = UUID.randomUUID();
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	@Override
	public void test() {
		System.out.println("Contact");
		ContactInherited contactInherited = new ContactInherited();
		//Before cherry-pick
	}

	private class ContactInherited{}

	private class ContractInherited2{}
}
