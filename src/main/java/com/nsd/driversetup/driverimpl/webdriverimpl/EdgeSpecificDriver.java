package com.nsd.driversetup.driverimpl.webdriverimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.nsd.driversetup.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeSpecificDriver {

WebDriver driver;
	
	public void driverSetup() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		DriverManager.setDriver(driver);
	}

}
