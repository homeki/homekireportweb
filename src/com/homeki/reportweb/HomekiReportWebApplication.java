package com.homeki.reportweb;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

import com.homeki.reportweb.rest.InstanceReportResource;

public class HomekiReportWebApplication extends Application {
	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());

//		router.attachDefault(new Directory(getContext(), "war:///"));
		router.attachDefault(InstanceReportResource.class);

		return router;
	}
}
