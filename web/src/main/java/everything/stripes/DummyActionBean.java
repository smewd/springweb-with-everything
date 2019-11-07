package everything.stripes;



import lombok.Getter;
import lombok.Setter;
import everything.service.ParentService;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;



@UrlBinding("/stripes/dummy.action")
public class DummyActionBean implements ActionBean
{
	@SpringBean("parentService")
	private ParentService service;

	@Getter
	@Setter
	private ActionBeanContext context;



	@DefaultHandler
	public Resolution defaultHandler()
	{
		return new ForwardResolution("/WEB-INF/stripes/dummy.jsp");
	}



	public String getHello()
	{
		return service.sayHello("DummyStripes.getHello (service: " + service + ")");
	}
}
