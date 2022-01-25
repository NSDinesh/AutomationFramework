package com.nsd.driversetup.enums;

import com.nsd.driversetup.driverimpl.mobiledriverimpl.AndroidSpecificDriver;
import com.nsd.driversetup.driverimpl.mobiledriverimpl.IosSpecificDriver;
import com.nsd.driversetup.driverimpl.webdriverimpl.ChromeSpecificDriver;
import com.nsd.driversetup.driverimpl.webdriverimpl.EdgeSpecificDriver;
import com.nsd.driversetup.driverimpl.webdriverimpl.FirefoxSpecficDriver;

public enum DriverType {

	CHROME("chrome") {
		@Override
		public void setDriverType() {
			new ChromeSpecificDriver().driverSetup();
		}
	},
	FIREFOX("firefox") {
		@Override
		public void setDriverType() {
			new FirefoxSpecficDriver().driverSetup();
		}
	},
	EDGE("edge") {
		@Override
		public void setDriverType() {
			new EdgeSpecificDriver().driverSetup();
		}
	},
	ANDROID("android") {
		@Override
		public void setDriverType() {
			new AndroidSpecificDriver().driverSetup();
		}
	},
	IOS("ios") {
		@Override
		public void setDriverType() {
			new IosSpecificDriver().driverSetup();
		}
	};

	private String driverType;

	private DriverType() {
	}

	private DriverType(String driverType) {
		this.driverType = driverType;
	}

	public String getDriverType() {
		return driverType;
	}

	public abstract void setDriverType();
	

}
