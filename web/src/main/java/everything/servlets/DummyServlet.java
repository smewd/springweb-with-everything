package everything.servlets;



import everything.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Component
public class DummyServlet extends HttpServlet
{
	private final ParentService parentService;



	@Autowired
	public DummyServlet(ParentService parentService)
	{
		this.parentService = parentService;
	}



	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doPost(req, resp);
	}



	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setHeader("Content-Type", "text/html");
		resp.getOutputStream().print("DummyServlet says: " + parentService.sayHello("world"));
	}
}
