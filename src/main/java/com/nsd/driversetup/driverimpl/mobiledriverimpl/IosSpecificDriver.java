package com.nsd.driversetup.driverimpl.mobiledriverimpl;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.nsd.driversetup.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class IosSpecificDriver {

	AppiumDriver<MobileElement> driver;

	public void driverSetup() {
		try {
			driver = new IOSDriver<>(new URL("https://127.0.0.1/"), new DesiredCapabilities());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		DriverManager.setDriver(driver);
	}

}
