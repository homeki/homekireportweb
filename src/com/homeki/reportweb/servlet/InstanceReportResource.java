package com.homeki.reportweb.servlet;

import static com.homeki.reportweb.datastore.OfyService.ofy;

import java.util.Calendar;
import java.util.List;

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
		htmlString.append("<tr><th>MAC address</th><th>Server name</th><th>Version</th><th>Device count</th><th>History point row count</th></tr>");
		
		for (Instance ins : instances) {
			htmlString.append("<tr>");
			htmlString.append("<td>" + ins.getMacAddress() + "</td>");
			htmlString.append("<td>" + ins.getServerName() + "</td>");
			htmlString.append("<td>" + ins.getVersion() + "</td>");
			htmlString.append("<td>" + ins.getDeviceCount() + "</td>");
			htmlString.append("<td>" + ins.getHistoryPointRowCount() + "</td>");
		}
		
		htmlString.append("</table>");
		htmlString.append("</body>");
		htmlString.append("</html>");
		
		return htmlString.toString();
	}
}
