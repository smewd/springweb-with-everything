package multicontexts.stripes;



import lombok.Getter;
import lombok.Setter;
import multicontexts.service.ParentService;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;



public class DummyActionBean implements ActionBean
{
	@SpringBean
	private ParentService parentService;

	@Getter
	@Setter
	private ActionBeanContext context;



	@DefaultHandler
	public Resolution defaultHandler()
	{
		return new ForwardResolution("/WEB-INF/jsp/dummy.jsp");
	}



	public String getHello()
	{
		return parentService.sayHello("DummyStripes.getHello");
	}
}
