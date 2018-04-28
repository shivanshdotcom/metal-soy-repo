package custom.soy.metal.sp4.portlet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author shivanssharma
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=CustomSoyMetalSp4", "mvc.command.name=AsynsProcess1"
	},
	service = MVCResourceCommand.class
)
public class CustomSoyMetalSp4UserMVCResourceCommand
	implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		JSONObject jSonObject = JSONFactoryUtil.createJSONObject();
		jSonObject.put("response", "success");
		jSonObject.put("loggedInUser", resourceRequest.getRemoteUser());
		try {
			resourceResponse.getWriter().write(jSonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}