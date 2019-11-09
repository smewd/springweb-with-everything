package everything.init;



import lombok.RequiredArgsConstructor;
import net.sourceforge.stripes.controller.DispatcherServlet;
import org.apache.struts.action.ActionServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;



@RequiredArgsConstructor
class ServletsConfig
{
	static final String STRIPES_DISPATCHER_SERVLETNAME = "StripesDispatcher";

	private final ServletContext servletContext;



	void init()
	{
		initStrutsServlet();
		initStripesServlet();
	}



	private void initStrutsServlet()
	{
		ActionServlet servlet = new ActionServlet();
		ServletRegistration.Dynamic servletReg = servletContext.addServlet("strutsActionServlet", servlet);
		servletReg.setLoadOnStartup(1);
		servletReg.setInitParameter("config", "/WEB-INF/struts-config.xml");
		servletReg.addMapping("*.do");
	}



	private void initStripesServlet()
	{
		DispatcherServlet servlet = new DispatcherServlet();
		ServletRegistration.Dynamic servletReg = servletContext.addServlet(STRIPES_DISPATCHER_SERVLETNAME, servlet);
		servletReg.setLoadOnStartup(1);
		servletReg.addMapping("*.action");
	}
}
