package everything.init;



import everything.servlet.DummyServlet;
import lombok.RequiredArgsConstructor;
import net.sourceforge.stripes.controller.DispatcherServlet;
import org.apache.struts.action.ActionServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import static everything.init.FiltersConfig.STRIPES_DISPATCHER_SERVLETNAME;



@RequiredArgsConstructor
class ServletsConfig
{
	private final ServletContext servletContext;



	void init()
	{
		initStrutsServlet();
		initStripesServlet();
		initDummyServlet();
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



	private void initDummyServlet()
	{
		DummyServlet servlet = new DummyServlet();
		ServletRegistration.Dynamic servletReg = servletContext.addServlet("dummyServlet", servlet);
		servletReg.setLoadOnStartup(1);
		servletReg.addMapping("/dummy/servlet");
	}
}
