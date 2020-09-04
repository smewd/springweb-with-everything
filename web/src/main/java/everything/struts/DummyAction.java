package everything.struts;



import everything.service.ParentService;
import lombok.Setter;



public class DummyAction //extends Action
{
	@Setter
	private ParentService service;



//	@Override
//	public ActionForward
//	execute(
//			ActionMapping mapping,
//			ActionForm form,
//			HttpServletRequest request,
//			HttpServletResponse response)
//	{
//		DummyForm strutsForm = (DummyForm)form;
//		strutsForm.setValue(service.sayHello("Struts DummyAction"));
//		return mapping.findForward("success");
//	}
}
