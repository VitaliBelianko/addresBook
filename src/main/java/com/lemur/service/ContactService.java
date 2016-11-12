package com.lemur.service;

import com.lemur.entity.Contact;

import java.util.Set;

/**
 * Created by Виталий on 30.10.2016.
 */
public interface ContactService {
	boolean persist(Contact contact);
	Set<String> getRandomData();

}
