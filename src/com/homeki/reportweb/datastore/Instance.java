package com.homeki.reportweb.datastore;

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
    private long historyPointRowCount;
    private int deviceCount;
	
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

	public String getVersion() {
		return version;
	}

	public String getServerName() {
		return serverName;
	}

	public Date getLastSeen() {
		return lastSeen;
	}

	public long getHistoryPointRowCount() {
		return historyPointRowCount;
	}

	public int getDeviceCount() {
		return deviceCount;
	}

	public void setHistoryPointRowCount(long historyPointRowCount) {
		this.historyPointRowCount = historyPointRowCount;
	}

	public void setDeviceCount(int deviceCount) {
		this.deviceCount = deviceCount;
	}
}
