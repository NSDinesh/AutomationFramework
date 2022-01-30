package com.nsd.driversetup;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager() {
		
	}
	
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public static <T extends WebDriver> void setDriver(T driver) {
		threadLocalDriver.set(driver);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends WebDriver> T getDriver() {
		return (T) threadLocalDriver.get();
	}
	
	public static void unload() {
		threadLocalDriver.remove();
	}
	
}
