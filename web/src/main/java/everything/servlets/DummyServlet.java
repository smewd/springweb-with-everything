package everything.servlets;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = "/servlet/dummy", loadOnStartup = 1)
public class DummyServlet extends HttpServlet
{
//	private final ParentService parentService;
//
//
//
////	@Autowired
//	public DummyServlet(ParentService parentService)
//	{
//		this.parentService = parentService;
//	}



	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doPost(req, resp);
	}



	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setHeader("Content-Type", "text/html");
		resp.getOutputStream().print("DummyServlet says: hello world");
//		resp.getOutputStream().print("DummyServlet says: " + parentService.sayHello("world"));
	}
}
