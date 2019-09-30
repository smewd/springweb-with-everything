package com.smood.parentcontext.config;



import com.smood.parentcontext.beans.ParentBean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;



public class WebAppInitializer implements WebApplicationInitializer
{
	@Override
	public void onStartup(ServletContext servletContext) {
		servletContext.setInitParameter(ContextLoader.LOCATOR_FACTORY_KEY_PARAM, ParentBean.PARENT_CONTEXT_ID);

		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(rootContext));

		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(MvcConfig.class);

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
