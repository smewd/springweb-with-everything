package com.smood.parentcontext.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@RestController
public class Web2Controller
{
	@GetMapping("/call")
	public String call()
	{
		return String.format("LocalDateTime in web2 is %s",
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
	}
}
