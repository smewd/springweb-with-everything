package com.smood.parentcontext.controllers;



import com.smood.parentcontext.beans.ParentBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;



@RestController
public class Web1Controller
{
	private final ParentBean parentBean;



	public Web1Controller(ParentBean parentBean)
	{
		this.parentBean = parentBean;
	}



	@GetMapping("/call")
	@ResponseBody
	public Map<String, Object> call()
	{
		Map<String, Object> result = new HashMap<>();
		result.put("localDateTime", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		result.put("parentValues", parentBean.getValues());
		return result;
	}
}
