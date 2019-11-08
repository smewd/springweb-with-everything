package everything.init;



import net.sourceforge.stripes.controller.StripesFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.EnumSet;

import static everything.init.ServletsConfig.STRIPES_DISPATCHER_SERVLETNAME;
import static javax.servlet.DispatcherType.REQUEST;



public class WebAppInitializer implements WebApplicationInitializer
{



	@Override
	public void onStartup(ServletContext servletContext)
	{
		servletContext.setInitParameter(ContextLoader.LOCATOR_FACTORY_KEY_PARAM, "ear.context");

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringContextConfig.class);

		ContextLoaderListener listener = new ContextLoaderListener(rootContext);
		servletContext.addListener(listener);

		new ServletsConfig(servletContext).init();
		initStripesFilter(servletContext);
	}



	private void initStripesFilter(ServletContext servletContext)
	{
		StripesFilter filter = new StripesFilter();
		FilterRegistration.Dynamic filterReg = servletContext.addFilter("StripesFilter", filter);
		filterReg.setInitParameter("Interceptor.Classes", net.sourceforge.stripes.integration.spring.SpringInterceptor.class.getCanonicalName());
		filterReg.setInitParameter("ActionResolver.Packages", everything.stripes.PackageMarker.class.getPackage().getName());
		filterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST), true, "*.action");
		filterReg.addMappingForServletNames(EnumSet.of(REQUEST), true, STRIPES_DISPATCHER_SERVLETNAME);
	}
}
