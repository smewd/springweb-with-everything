package everything.init;



import everything.config.ParentContextConfig;
import everything.servlets.DummyServlet;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;



@Configuration
@Import({
		ParentContextConfig.class
})
class SpringContextConfig
{
}
