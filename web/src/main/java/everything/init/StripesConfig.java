package everything.init;



import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StripesConfig
{
	private static final String STRIPES_DISPATCHER_SERVLETNAME = "stripes-dispatcherservlet";



	@Bean
	public ServletRegistrationBean<DispatcherServlet> stripesServlet()
	{
		DispatcherServlet servlet = new DispatcherServlet();
		ServletRegistrationBean<DispatcherServlet> bean = new ServletRegistrationBean<>(servlet);
		bean.setName(STRIPES_DISPATCHER_SERVLETNAME);
		bean.addUrlMappings("*.action");
		bean.setLoadOnStartup(1);
		return bean;
	}



	@Bean
	public FilterRegistrationBean<StripesFilter> stripesFilter()
	{
		FilterRegistrationBean<StripesFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new StripesFilter());
		bean.addInitParameter("Interceptor.Classes", net.sourceforge.stripes.integration.spring.SpringInterceptor.class.getCanonicalName());
		bean.addInitParameter("ActionResolver.Packages", everything.stripes.PackageMarker.class.getPackage().getName());
		bean.addServletNames(STRIPES_DISPATCHER_SERVLETNAME);
		bean.addUrlPatterns("*.action");
//		bean.addMappingForServletNames(EnumSet.of(REQUEST), true, STRIPES_DISPATCHER_SERVLETNAME);
		return bean;
	}
}
