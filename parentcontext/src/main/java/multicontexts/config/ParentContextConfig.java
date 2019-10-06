package multicontexts.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackageClasses = multicontexts.service.ParentService.class)
public class ParentContextConfig
{
}
