package everything.web;



import everything.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class DummyController
{
	private final ParentService service;


	@Autowired
	public DummyController(ParentService service)
	{
		this.service = service;
	}



	@GetMapping(value = "/hello", produces = "text/plain")
	@ResponseBody
	public String first()
	{
		return service.sayHello("first");
	}
}
