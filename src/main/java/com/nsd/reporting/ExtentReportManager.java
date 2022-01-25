package com.nsd.reporting;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportManager {
	
	private static ThreadLocal<ExtentReports> extentReports = new InheritableThreadLocal<>();

	public static ExtentReports getExtentReports() {
		return extentReports.get();
	}

	public static void setExtentReports(ExtentReports reports) {
		extentReports.set(reports);
	}
	
	public static void unload() {
		extentReports.remove();
	}
	
	
}
