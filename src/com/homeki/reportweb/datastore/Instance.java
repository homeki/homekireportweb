package com.homeki.reportweb.datastore;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Date;

@Entity
public class Instance {
	@Id
	private String serverUuid;
	private String version;
	private String serverName;
	private Date lastSeen;
	private long historyPointRowCount;
	private int deviceCount;

	public Instance() {

	}

	public Instance(String serverUuid) {
		this.serverUuid = serverUuid;
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

	public String getServerUuid() {
		return serverUuid;
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
