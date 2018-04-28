package custom.soy.metal.sp4.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author shivanssharma
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=CustomSoyMetalSp4", "mvc.command.name=Navigation"
	},
	service = MVCRenderCommand.class
)
public class CustomSoyMetalSp4NavigationMVCRenderCommand
	implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		PortletURL navigationURL = renderResponse.createRenderURL();

		navigationURL.setParameter("mvcRenderCommandName", "View");

		template.put("navigationURL", navigationURL.toString());

		return "Navigation";
	}

}