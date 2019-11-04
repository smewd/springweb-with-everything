package everything.init;



import everything.service.ParentService;
import everything.struts.DummyAction;
import everything.web.DummyController;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
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
		new ServletsConfig(servletContext).init();
		new FiltersConfig(servletContext).init();
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






	@NoArgsConstructor
	@Configuration
	private static class SpringContextConfig
	{
		@Bean
		public DummyAction dummyAction(ParentService parentService)
		{
			System.out.println("\n\n\n" + parentService + "\n\n\n");
			DummyAction dummyAction = new DummyAction();
			dummyAction.setParentService(parentService);
			return dummyAction;
		}
	}



	@NoArgsConstructor
	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackageClasses = {
			DummyController.class,
	})
	private static class DispatcherServletConfig
	{
	}
}
