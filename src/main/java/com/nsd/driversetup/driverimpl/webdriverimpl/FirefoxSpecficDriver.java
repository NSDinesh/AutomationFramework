package com.nsd.driversetup.driverimpl.webdriverimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nsd.driversetup.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxSpecficDriver {

	WebDriver driver;

	public void driverSetup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		DriverManager.setDriver(driver);
	}
	
}
