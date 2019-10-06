package multicontexts.web;



import multicontexts.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class SecondController
{
	private final ParentService service;


	@Autowired
	public SecondController(ParentService service)
	{
		this.service = service;
		System.out.println("\n\nSECONDCONTROLLER\n\n");
	}



	@GetMapping(value = "/", produces = "text/plain")
	@ResponseBody
	public String first()
	{
		return service.sayHello("second");
	}
}
