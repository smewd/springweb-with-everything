package multicontexts.service;



import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Service
public class ParentService
{
	public String sayHello(String from)
	{
		return "Hello from " + from;
	}
}
