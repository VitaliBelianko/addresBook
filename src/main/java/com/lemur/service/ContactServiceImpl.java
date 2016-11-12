package com.lemur.service;

import com.lemur.entity.Contact;
import com.lemur.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Виталий on 30.10.2016.
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {
	private static final Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Override
	public boolean persist(Contact contact) {
		try {
			contactRepository.persist(contact);
			return true;
		} catch (Exception e) {
			LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Set<String> getRandomData() {
		return contactRepository.getRandomData();
	}
}
