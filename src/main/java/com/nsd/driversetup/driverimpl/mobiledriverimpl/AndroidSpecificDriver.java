package com.nsd.driversetup.driverimpl.mobiledriverimpl;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.nsd.driversetup.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidSpecificDriver {

	AppiumDriver<MobileElement> driver;

	public void driverSetup() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("automationName", "uiAutomator2");
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("udid", "emulator-5554");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		try {
			driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		DriverManager.setDriver(driver);
	}

}
