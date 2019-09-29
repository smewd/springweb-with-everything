package controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@RestController
public class Web1Controller
{
	@GetMapping("/call")
	public String call()
	{
		return String.format("LocalDateTime in web1 is %s",
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
	}
}
