package everything.init;



import org.apache.struts.action.ActionServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;



@Configuration
@ImportResource({
		"classpath:struts-actions.xml",
})
public class StrutsConfig
{
	private static final String STRUTS_ACTIONSERVLET = "struts-actionservlet";



	@Bean
	public ServletRegistrationBean strutsServletBean()
	{
		ActionServlet servlet = new ActionServlet();
		ServletRegistrationBean bean = new ServletRegistrationBean(servlet);
		bean.setLoadOnStartup(1);
		bean.addInitParameter("config", "/WEB-INF/struts-config.xml");
		bean.setName(STRUTS_ACTIONSERVLET);
		bean.addUrlMappings("*.do");
		return bean;
	}
}
