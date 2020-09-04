package everything.init;



import everything.servlets.DummyServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackageClasses = {
		DummyServlet.class,
})
public class ServletConfig
{
	@Autowired
	private DummyServlet dummyServlet;



	@Bean
	public ServletRegistrationBean resetServletRegistrationBean()
	{
		return new ServletRegistrationBean(dummyServlet, "/servlet/dummy");
	}
}
