package com.nsd.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static void initReports(String report) {
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(report);
		extentReport.attachReporter(spark);
		ExtentReportManager.setExtentReports(extentReport);
	}
	
	public static void flushReports() {
		ExtentReportManager.getExtentReports().flush();
	}
	
	public static void createTest(String testCaseName) {
		ExtentTest extentTest = ExtentReportManager.getExtentReports().createTest(testCaseName);
		ExtentTestManager.setExtentTest(extentTest);
	}

}
