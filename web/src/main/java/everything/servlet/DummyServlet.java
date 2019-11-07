package everything.servlet;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class DummyServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doPost(req, resp);
	}



	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setHeader("Content-Type", "text/html");
		resp.getOutputStream().print("DummyServlet says hello!");
	}
}
