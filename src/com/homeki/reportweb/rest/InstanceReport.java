package com.homeki.reportweb.rest;

import java.io.Serializable;

public class InstanceReport implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String macAddress;
    private String serverName;
    private String version;
    private long historyPointRowCount;
    private int deviceCount;
    private double systemLoad;
    
	public String getServerName() {
		return serverName;
	}

	public String getVersion() {
		return version;
	}
    
	public String getMacAddress() {
		return macAddress;
	}
	
	public long getHistoryPointRowCount() {
		return historyPointRowCount;
	}
	
	public int getDeviceCount() {
		return deviceCount;
	}
	
	public double getSystemLoad() {
		return systemLoad;
	}
	
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
	public void setHistoryPointRowCount(long historyPointRowCount) {
		this.historyPointRowCount = historyPointRowCount;
	}
	
	public void setDeviceCount(int deviceCount) {
		this.deviceCount = deviceCount;
	}
	
	public void setSystemLoad(double systemLoad) {
		this.systemLoad = systemLoad;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
