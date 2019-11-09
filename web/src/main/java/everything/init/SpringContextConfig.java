package everything.init;



import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;



@Configuration
@ImportResource({
		"classpath:services-context.xml",
		"classpath:struts-actions.xml",
})
class SpringContextConfig
{
}
