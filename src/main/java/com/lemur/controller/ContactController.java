package com.lemur.controller;

import com.lemur.entity.Contact;
import com.lemur.entity.DomainObject;
import com.lemur.entity.SuperContact;
import com.lemur.exceptions.RestException;
import com.lemur.service.ContactService;
import com.lemur.utils.Ajax;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Set;

/**
 * Created by Виталий on 30.10.2016.
 */
@Controller
public class ContactController extends ExceptionHandlerController {

	private static final Logger LOG = Logger.getLogger(ContactController.class);

	@Autowired
	@Qualifier("contactService")
	private ContactService contactService;

	@RequestMapping(value = "/persist", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> persist(@RequestParam("data") Contact contact) throws RestException {
		try {
			if (contact == null) {
				return Ajax.emptyResponse();
			}
			contactService.persist(contact);
			return Ajax.emptyResponse();
		} catch (Exception e) {
			throw new RestException(e);
		}
	}

	@RequestMapping(value = "/getRandomData", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getRandomData() throws RestException {
		try {
			DomainObject object = new SuperContact();
			object.test();
			object = new Contact();
			object.test();


			Set<String> result = contactService.getRandomData();
			return Ajax.successResponse(result);
		} catch (Exception e) {
			throw new RestException(e);
		}
	}


}
