package everything.struts;



import everything.service.ParentService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Getter
@Setter
public class DummyAction extends ActionSupport
{
	private ParentService parentService;



	@Override
	public ActionForward
	execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	{
		DummyForm strutsForm = (DummyForm)form;
		strutsForm.setValue(parentService.sayHello("struts"));
		return mapping.findForward("success");
	}
}
