package everything.service;



import org.springframework.stereotype.Service;



@Service
public class ParentService
{
	public String sayHello(String from)
	{
		return "Hello from " + from;
	}
}
