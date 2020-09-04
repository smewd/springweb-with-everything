package everything.filters;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.DispatcherType.REQUEST;



@WebFilter(dispatcherTypes = REQUEST, urlPatterns = {"*.action", "*.do"})
public class DecoratingFilter implements Filter
{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException
	{
		HtmlResponseWrapper capturingResponseWrapper = new HtmlResponseWrapper((HttpServletResponse)response);
		filterChain.doFilter(request, capturingResponseWrapper);

		String content = capturingResponseWrapper.getCaptureAsString();
		String replacedContent = String.format("Decorating filter: <blockquote>%s</blockquote>", content);

		response.setContentLength(replacedContent.length());
		response.getWriter().write(replacedContent);
	}



	@Override
	public void init(FilterConfig filterConfig)
	{
	}



	@Override
	public void destroy()
	{
	}
}
