package com.lemur.controller;

import com.lemur.exceptions.RestException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Виталий on 30.10.2016.
 */
@Controller
public class ExceptionHandlerController {
	private static final Logger LOG = Logger.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(RestException.class)
	public @ResponseBody
	String handleException(RestException e) {
		LOG.error("Error: " + e.getMessage(), e);
		return "Error: " + e.getMessage();
	}
}
