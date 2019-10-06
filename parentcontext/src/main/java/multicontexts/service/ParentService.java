package multicontexts.service;



import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Service
public class ParentService
{
	public ParentService()
	{
		System.out.println(String.format("%n%n%n%s: Uppstart av %s klar.%n%n%n",
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
				getClass().getName()));
	}



	public String sayHello(String from)
	{
		return "Hello from " + from;
	}

}
