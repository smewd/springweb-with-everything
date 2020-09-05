package everything.init;



import everything.config.ParentContextConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import(ParentContextConfig.class)
class SpringContextConfig
{
}