package everything.struts;



import everything.service.ParentService;
import lombok.Setter;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;



public class DummyAction extends Action
{
	@Setter
	private ParentService service;



	@Override
	public ActionForward
	execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	{
		DummyForm strutsForm = (DummyForm)form;
		strutsForm.setValue(service.sayHello("Struts DummyAction"));
		return mapping.findForward("success");
	}
}
