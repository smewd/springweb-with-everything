package everything.init;



import everything.filter.LoggingFilter;
import everything.filter.DecoratingFilter;
import lombok.RequiredArgsConstructor;
import net.sourceforge.stripes.controller.StripesFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.EnumSet;

import static javax.servlet.DispatcherType.REQUEST;



@RequiredArgsConstructor
class FiltersConfig
{
	static final String STRIPES_DISPATCHER_SERVLETNAME = "StripesDispatcher";

	private final ServletContext servletContext;



	void init()
	{
		initLoggingFilter();
		initDecoratingFilter();
		initStripesFilter();
	}



	private void initLoggingFilter()
	{
		LoggingFilter filter = new LoggingFilter();
		FilterRegistration.Dynamic filterReg = servletContext.addFilter(
				filter.getClass().getName() + "Filter", filter);
		filterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST), true, "/*");
	}



	private void initDecoratingFilter()
	{
		DecoratingFilter filter = new DecoratingFilter();
		FilterRegistration.Dynamic filterReg = servletContext.addFilter(
				filter.getClass().getName() + "Filter", filter);
		filterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST), true, "/*.action", "/*.do");
	}



	private void initStripesFilter()
	{
		StripesFilter filter = new StripesFilter();
		FilterRegistration.Dynamic filterReg = servletContext.addFilter("StripesFilter", filter);
		filterReg.setInitParameter("Interceptor.Classes", net.sourceforge.stripes.integration.spring.SpringInterceptor.class.getCanonicalName());
		filterReg.setInitParameter("ActionResolver.Packages", everything.stripes.PackageMarker.class.getPackage().getName());
		filterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST), true, "*.action");
		filterReg.addMappingForServletNames(EnumSet.of(REQUEST), true, STRIPES_DISPATCHER_SERVLETNAME);
	}
}
