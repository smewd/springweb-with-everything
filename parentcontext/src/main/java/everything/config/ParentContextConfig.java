package everything.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackageClasses = everything.service.ParentService.class)
public class ParentContextConfig
{
}
