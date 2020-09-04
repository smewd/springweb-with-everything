package everything.init;



import org.apache.struts.action.ActionServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;



//@Configuration
@ImportResource({
		"classpath:struts-actions.xml",
})
public class StrutsConfig
{
	@Bean
	public ServletRegistrationBean<ActionServlet> strutsServletBean()
	{
		ActionServlet servlet = new ActionServlet();
		ServletRegistrationBean<ActionServlet> bean
				= new ServletRegistrationBean<>(servlet);
		bean.setLoadOnStartup(1);
		bean.addInitParameter("config", "/WEB-INF/struts-config.xml");
		bean.addUrlMappings("*.do");
		return bean;
	}
}
