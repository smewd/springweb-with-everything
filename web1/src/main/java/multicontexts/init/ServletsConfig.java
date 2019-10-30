package multicontexts.init;



import lombok.RequiredArgsConstructor;
import multicontexts.servlet.DummyServlet;
import net.sourceforge.stripes.controller.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import static multicontexts.init.FiltersConfig.STRIPES_DISPATCHER_SERVLETNAME;



@RequiredArgsConstructor
public class ServletsConfig
{
	private final ServletContext servletContext;



	void init()
	{
		initStripesServlet();
		initDummyServlet();
	}



	private void initStripesServlet()
	{
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		ServletRegistration.Dynamic stripesServletReg = servletContext.addServlet(STRIPES_DISPATCHER_SERVLETNAME,
				dispatcherServlet);
		stripesServletReg.setLoadOnStartup(1);
		stripesServletReg.addMapping("*.action");
	}



	private void initDummyServlet()
	{
		DummyServlet dummyServlet = new DummyServlet();
		ServletRegistration.Dynamic servletReg = servletContext.addServlet("dummyServlet", dummyServlet);
		servletReg.setLoadOnStartup(1);
		servletReg.addMapping("/dummy/servlet");
	}
}
