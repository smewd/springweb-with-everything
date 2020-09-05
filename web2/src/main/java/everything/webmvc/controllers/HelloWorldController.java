package everything.webmvc.controllers;



import everything.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/webmvc")
public class HelloWorldController
{
	private final ParentService service;



	@Autowired
	public HelloWorldController(ParentService service)
	{
		this.service = service;
	}



	@GetMapping(value = "/helloworld", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> helloworld()
	{
		Map<String, String> map = new HashMap<>();
		map.put("hello2", service.sayHello("world"));
		return map;
	}
}
