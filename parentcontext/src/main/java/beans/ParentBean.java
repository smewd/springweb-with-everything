package beans;



import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Component
public class ParentBean
{
	public String getName()
	{
		return String.format("ParentBean %s",
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
	}
}
