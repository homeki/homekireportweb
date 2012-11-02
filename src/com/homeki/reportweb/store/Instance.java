package com.homeki.reportweb.store;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Instance {
	@Id
	private String macAddress;
	private String version;
	private String serverName;
	private Date lastSeen;
	
	public Instance() {
		
	}
	
	public Instance(String macAddress) {
		this.macAddress = macAddress;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}

	public String getMacAddress() {
		return macAddress;
	}
}
