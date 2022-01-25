package com.nsd.driversetup.driverimpl.webdriverimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nsd.driversetup.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeSpecificDriver {
	
	WebDriver driver;
	
	public void driverSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		DriverManager.setDriver(driver);
	}

}
