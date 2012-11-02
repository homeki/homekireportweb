package com.homeki.reportweb.store;

import java.util.Calendar;
import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Report {
	@Id
	private Long id;
	private Date registered;
	private Key<Instance> instance;
    private long historyPointRowCount;
    private int deviceCount;
    private double systemLoad;
    
    public Report() {
    	
    }
    
    public Report(Instance instance) {
    	this.registered = Calendar.getInstance().getTime();
    	this.instance = Key.create(Instance.class, instance.getMacAddress());
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
}
