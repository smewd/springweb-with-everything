package multicontexts.init;



import lombok.NoArgsConstructor;
import multicontexts.servlet.DummyServlet;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;



public class WebAppInitializer implements WebApplicationInitializer
{
	@Override
	public void onStartup(ServletContext servletContext)
	{
		servletContext.setInitParameter(ContextLoader.LOCATOR_FACTORY_KEY_PARAM, "ear.context");
		initSpringContext(servletContext);
		initDispatcherServlet(servletContext);
		initServlets(servletContext);
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
		DummyServlet dummyServlet = new DummyServlet();
		ServletRegistration.Dynamic servletReg = servletContext.addServlet("dummyServlet", dummyServlet);
		servletReg.setLoadOnStartup(1);
		servletReg.addMapping("/dummy/servlet");
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
