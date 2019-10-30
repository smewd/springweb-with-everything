package multicontexts.init;



import lombok.RequiredArgsConstructor;
import multicontexts.filter.Forstafilter;
import multicontexts.filter.Andrafilter;
import net.sourceforge.stripes.controller.StripesFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.EnumSet;

import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.REQUEST;



@RequiredArgsConstructor
class FiltersConfig
{
	static final String STRIPES_DISPATCHER_SERVLETNAME = "StripesDispatcher";

	private final ServletContext servletContext;



	void init()
	{
		initStripesFilter();
		initForstafilter();
		initAndrafilter();
	}



	private void initStripesFilter()
	{
		StripesFilter filter = new StripesFilter();
		FilterRegistration.Dynamic filterReg = servletContext.addFilter("StripesFilter", filter);
		filterReg.setInitParameter("Interceptor.Classes", net.sourceforge.stripes.integration.spring.SpringInterceptor.class.getCanonicalName());
		filterReg.setInitParameter("ActionResolver.Packages", multicontexts.stripes.PackageMarker.class.getPackage().getName());
		filterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST), true, "*.action");
		filterReg.addMappingForServletNames(EnumSet.of(REQUEST), true, STRIPES_DISPATCHER_SERVLETNAME);
	}



	private void initForstafilter()
	{
		Forstafilter filter = new Forstafilter();
		FilterRegistration.Dynamic filterReg = servletContext.addFilter("firstFilter", filter);
		filterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST, FORWARD), true, "/");
	}



	private void initAndrafilter()
	{
		Andrafilter filter = new Andrafilter();
		FilterRegistration.Dynamic filterReg = servletContext.addFilter("secondFilter", filter);
		filterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST, FORWARD), true, "/");
	}
}
