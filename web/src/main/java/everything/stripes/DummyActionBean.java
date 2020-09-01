package everything.stripes;



import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Getter;
import lombok.Setter;
import everything.service.ParentService;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;


@UrlBinding("/stripes/dummy.action")
public class DummyActionBean implements ActionBean
{
	static final String VIEW = "/WEB-INF/stripes/dummy.jsp";
	@SpringBean
	private ParentService parentService;

	@Validate(required = true, on = "posta")
	@Getter
	@Setter
	private String dummyvarde;


	@Getter
	@Setter
	private ActionBeanContext context;



	@DefaultHandler
	public Resolution defaultHandler()
	{
		return new ForwardResolution(VIEW);
	}



	@HandlesEvent("posta")
	public Resolution posta()
	{
		return new ForwardResolution(VIEW);
	}


	public String getHello()
	{
		return parentService.sayHello("DummyActionBean.getHello");
	}
}
