package com.nsd.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.nsd.reporting.ExtentReport;

public class Listeners implements ISuiteListener, ITestListener{

	public void onStart(ISuite suite) {

	}

	public void onFinish(ISuite suite) {

	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {

	}



}
