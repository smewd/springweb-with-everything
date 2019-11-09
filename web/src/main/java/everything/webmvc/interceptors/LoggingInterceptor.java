package everything.webmvc.interceptors;



import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;



public class LoggingInterceptor extends HandlerInterceptorAdapter
{
	private static final Logger LOGGER = Logger.getLogger(LoggingInterceptor.class.getName());



	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
	{
		LOGGER.info("Logging in LoggerInterceptor");
		return true;
	}
}
