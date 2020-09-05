package everything.healthindicators;



import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;



@Component
public class DummyHealthIndicator implements HealthIndicator
{
	@PostConstruct
	public void postConstruct()
	{
		System.out.printf("%n%n%s.postConstruct()%n%n", getClass().getName());
	}



	@Override
	public Health health()
	{
		return Health.down()
				.withDetail("detail1", "value1")
				.withDetail("detail2", "value2")
				.build();
	}
}
