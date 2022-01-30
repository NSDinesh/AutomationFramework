package com.nsd.reporting;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.nsd.utils.ScreenshotUtils;

public final class ExtentLogger {
	
	private ExtentLogger(){}

    public static void pass(String message){
    	System.out.println(ExtentTestManager.getExtentTest());
        ExtentTestManager.getExtentTest().pass(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShotAsByte()).build());
    }

    public static void fail(String message){
    	ExtentTestManager.getExtentTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShotAsByte()).build());
    }

    public static void info(String message){
    	ExtentTestManager.getExtentTest().info(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShotAsByte()).build());
    }

}
