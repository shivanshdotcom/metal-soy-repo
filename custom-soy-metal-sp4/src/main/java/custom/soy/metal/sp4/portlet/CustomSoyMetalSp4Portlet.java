package custom.soy.metal.sp4.portlet;

import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.portlet.bridge.soy.SoyPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

import org.osgi.service.component.annotations.Component;


/**
 * @author shivanssharma
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Custom Soy Metal SP4 Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=View",
		"javax.portlet.name=CustomSoyMetalSp4",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomSoyMetalSp4Portlet extends SoyPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		System.out.println("Portlet class render method"+ template);

		PortletURL navigationURL = renderResponse.createRenderURL();

		navigationURL.setParameter("mvcRenderCommandName", "Navigation");
		
		template.put("navigationURL", navigationURL.toString());
		
//		ResourceURL processRequestURL = renderResponse.createResourceURL();
//		
//		processRequestURL.setParameter("mvcResourceCommandName", "AsynsProcess1");
		
		ResourceURL processRequestURL = renderResponse.createResourceURL();
		
		processRequestURL.setResourceID("AsynsProcess1"); 
		
		template.put("processRequestURL", processRequestURL.toString());

		template.put("releaseInfo", ReleaseInfo.getReleaseInfo());

		template.put("customMessage", "Here is default metal library and HTML5 component usage");
		
		String[] userArray = new String[]{"Akram", "Vasanth", "Saba"};
		
		template.put("userNames", userArray);
		
		template.put("placeholder", "Please enter the name");

		super.render(renderRequest, renderResponse);
	}

}