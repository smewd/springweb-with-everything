package everything.webmvc;



import everything.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



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



	@GetMapping("/dummy")
	public String dummy()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("dummyValue", service.sayHello("Spring WebMVC DummyController"));
		return "dummy";
	}



	@GetMapping("/test")
	@ResponseBody
	public String test()
	{
		return "dummy";
	}
}
