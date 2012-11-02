package com.homeki.reportweb.servlet;

import static com.homeki.reportweb.datastore.OfyService.ofy;

import java.util.Calendar;
import java.util.List;

import org.restlet.data.Status;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.homeki.reportweb.datastore.Instance;

public class InstanceReportResource extends ServerResource {
	@Put("json")
	public void store(InstanceReport insreport) {
		Instance instance = ofy().load().type(Instance.class).id(insreport.getMacAddress()).get();
		
		if (instance == null)
			instance = new Instance(insreport.getMacAddress());
		
		instance.setLastSeen(Calendar.getInstance().getTime());
		instance.setServerName(insreport.getServerName());
		instance.setVersion(insreport.getVersion());
		instance.setDeviceCount(insreport.getDeviceCount());
		instance.setHistoryPointRowCount(insreport.getHistoryPointRowCount());
		
		ofy().save().entity(instance).now();
	}
	
	@Delete
	public void remove() {
		String macAddress = getQuery().getFirstValue("mac", true);
		
		if (macAddress == null) {
			setStatus(Status.CLIENT_ERROR_BAD_REQUEST, "Missing 'mac' argument.");
			return;
		}
		
		ofy().delete().type(Instance.class).id(macAddress).now();
	}
	
	@Get("html")
	public String respond() {
		List<Instance> instances = ofy().load().type(Instance.class).list();
		
		StringBuilder htmlString = new StringBuilder();
		htmlString.append("<html>");
		htmlString.append("<head>");
		htmlString.append("<title>Homeki Report Web</title>");
		htmlString.append("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
		htmlString.append("</head>");
		htmlString.append("<body>");
		htmlString.append("<table cellspacing=\"0\" cellpadding=\"3\" style=\"width:100%;\">");
		htmlString.append("<tr><th>MAC address</th><th>Server name</th><th>Last seen</th><th>Version</th><th>Device count</th><th>History point row count</th></tr>");
		
		for (Instance ins : instances) {
			htmlString.append("<tr>");
			htmlString.append("<td>" + ins.getMacAddress() + "</td>");
			htmlString.append("<td>" + ins.getServerName() + "</td>");
			htmlString.append("<td>" + ins.getLastSeen() + "</td>");
			htmlString.append("<td>" + ins.getVersion() + "</td>");
			htmlString.append("<td>" + ins.getDeviceCount() + "</td>");
			htmlString.append("<td>" + ins.getHistoryPointRowCount() + "</td>");
			htmlString.append("</tr>");
		}
		
		htmlString.append("</table>");
		htmlString.append("</body>");
		htmlString.append("</html>");
		
		return htmlString.toString();
	}
}
