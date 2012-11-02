package com.homeki.reportweb.rest;

import static com.homeki.reportweb.store.OfyService.ofy;

import java.util.Calendar;

import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.homeki.reportweb.store.Instance;

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
		
		ofy().save().entities(instance).now();
	}
	
	@Get
	public String respond() {
		return "No point to GET this resource.";
	}
}
