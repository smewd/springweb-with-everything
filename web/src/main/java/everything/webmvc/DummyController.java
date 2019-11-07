package everything.webmvc;



import everything.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/webmvc")
public class DummyController
{
	private final ParentService service;


	@Autowired
	public DummyController(ParentService service)
	{
		this.service = service;
	}



	@GetMapping(value = "/dummy", produces = "text/plain")
	@ResponseBody
	public String first()
	{
		return service.sayHello("Spring WebMVC DummyController");
	}
}
