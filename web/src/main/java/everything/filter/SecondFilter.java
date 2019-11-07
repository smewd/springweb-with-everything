package everything.filter;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class SecondFilter implements Filter
{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException
	{
		HtmlResponseWrapper capturingResponseWrapper = new HtmlResponseWrapper((HttpServletResponse)response);
		filterChain.doFilter(request, capturingResponseWrapper);

		String content = capturingResponseWrapper.getCaptureAsString();
		String replacedContent = String.format("Second filter <blockquote>%s</blockquote> Second filter", content);

		response.setContentLength(replacedContent.length());
		response.getWriter().write(replacedContent);
	}
}
