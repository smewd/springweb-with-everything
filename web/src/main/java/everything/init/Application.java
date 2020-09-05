package everything.init;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class
})
public class Application extends SpringBootServletInitializer
{
}
