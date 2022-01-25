package com.nsd.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.nsd.driversetup.DriverManager;

public class ScreenshotUtils {
	
	private ScreenshotUtils() {
		
	}
	
	public static String getScreenShotAsByte() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
 