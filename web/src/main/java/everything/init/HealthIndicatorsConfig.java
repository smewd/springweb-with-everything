package everything.init;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackageClasses = {
		everything.healthindicators.PackageMarker.class,
})
public class HealthIndicatorsConfig
{
}
