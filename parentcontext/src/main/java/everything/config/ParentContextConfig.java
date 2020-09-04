package everything.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;



@Configuration
@ImportResource("classpath:services-context.xml")
public class ParentContextConfig
{
}
