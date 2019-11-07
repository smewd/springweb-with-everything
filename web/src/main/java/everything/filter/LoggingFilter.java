package everything.filter;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Logger;



public class LoggingFilter implements Filter
{
	private static final Logger LOGGER = Logger.getLogger(LoggingFilter.class.getName());



	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException
	{
		LOGGER.info("doFilter");
		filterChain.doFilter(request, response);
	}
}
