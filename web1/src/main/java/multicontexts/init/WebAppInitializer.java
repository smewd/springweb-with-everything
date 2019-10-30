package multicontexts.init;



import lombok.NoArgsConstructor;
import multicontexts.filter.DummyFilter;
import multicontexts.servlet.DummyServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.REQUEST;



public class WebAppInitializer implements WebApplicationInitializer
{
	private static final String STRIPES_DISPATCHER_SERVLETNAME = "StripesDispatcher";



	@Override
	public void onStartup(ServletContext servletContext)
	{
		servletContext.setInitParameter(ContextLoader.LOCATOR_FACTORY_KEY_PARAM, "ear.context");
		initSpringContext(servletContext);
		initDispatcherServlet(servletContext);
		initServlets(servletContext);
		initFilters(servletContext);
	}



	private void initSpringContext(ServletContext servletContext)
	{
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringContextConfig.class);

		ContextLoaderListener listener = new ContextLoaderListener(rootContext);
		servletContext.addListener(listener);
	}



	private void initDispatcherServlet(ServletContext servletContext)
	{
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(DispatcherServletConfig.class);

		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(context));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/");
	}



	private void initServlets(ServletContext servletContext)
	{
		net.sourceforge.stripes.controller.DispatcherServlet dispatcherServlet = new net.sourceforge.stripes.controller.DispatcherServlet();
		ServletRegistration.Dynamic stripesServletReg = servletContext.addServlet(STRIPES_DISPATCHER_SERVLETNAME,
				dispatcherServlet);
		stripesServletReg.setLoadOnStartup(1);
		stripesServletReg.addMapping("*.action");

		DummyServlet dummyServlet = new DummyServlet();
		ServletRegistration.Dynamic servletReg = servletContext.addServlet("dummyServlet", dummyServlet);
		servletReg.setLoadOnStartup(1);
		servletReg.addMapping("/dummy/servlet");
	}



	private void initFilters(ServletContext servletContext)
	{
		StripesFilter stripesFilter = new StripesFilter();
		FilterRegistration.Dynamic stripesFilterReg = servletContext.addFilter("StripesFilter", stripesFilter);
		stripesFilterReg.setInitParameter("Interceptor.Classes", net.sourceforge.stripes.integration.spring.SpringInterceptor.class.getCanonicalName());
		stripesFilterReg.setInitParameter("ActionResolver.Packages", multicontexts.stripes.PackageMarker.class.getPackage().getName());
		stripesFilterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST), true, "*.action");
		stripesFilterReg.addMappingForServletNames(EnumSet.of(REQUEST), true, STRIPES_DISPATCHER_SERVLETNAME);

		DummyFilter dummyFilter = new DummyFilter();
		FilterRegistration.Dynamic dummyFilterReg = servletContext.addFilter("dummyFilter", dummyFilter);
		dummyFilterReg.addMappingForUrlPatterns(EnumSet.of(REQUEST, FORWARD), true, "/");
	}



	@NoArgsConstructor
	@Configuration
	private static class SpringContextConfig
	{
	}



	@NoArgsConstructor
	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackageClasses = {
			multicontexts.web.FirstController.class,
	})
	private static class DispatcherServletConfig
	{
	}
}
