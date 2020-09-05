package everything.init;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {
		everything.webmvc.controllers.PackageMarker.class,
})
class DispatcherServletConfig
{
}
