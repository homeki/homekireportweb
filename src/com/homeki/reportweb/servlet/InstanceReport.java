package com.homeki.reportweb.servlet;

import java.io.Serializable;

public class InstanceReport implements Serializable {
	private static final long serialVersionUID = 1L;

	private String serverUuid;
	private String serverName;
	private String version;
	private long historyPointRowCount;
	private int deviceCount;

	public String getServerName() {
	return serverName;
}

	public String getVersion() {
		return version;
	}
    
	public String getServerUuid() {
		return serverUuid;
	}
	
	public long getHistoryPointRowCount() {
		return historyPointRowCount;
	}
	
	public int getDeviceCount() {
		return deviceCount;
	}
	
	public void setServerUuid(String serverUuid) {
		this.serverUuid = serverUuid;
	}
	
	public void setHistoryPointRowCount(long historyPointRowCount) {
		this.historyPointRowCount = historyPointRowCount;
	}
	
	public void setDeviceCount(int deviceCount) {
		this.deviceCount = deviceCount;
	}
	
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
