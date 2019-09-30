package com.smood.parentcontext.controllers;


import com.smood.parentcontext.beans.ParentBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@RestController
public class Web1Controller
{
	private final ParentBean parentBean;



	public Web1Controller(ParentBean parentBean)
	{
		this.parentBean = parentBean;
	}



	@GetMapping("/call")
	public String call()
	{
		return String.format("LocalDateTime in web1 is %s%nParent bean säger: %s",
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
				parentBean.getName());
	}
}
