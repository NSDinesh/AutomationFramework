package com.nsd.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.nsd.annotation.FrameworkAnnotation;
import com.nsd.reporting.ExtentReport;

public class Listeners implements ISuiteListener, ITestListener{

	public void onStart(ISuite suite) {

	}

	public void onFinish(ISuite suite) {

	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getName());
		if(result.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(FrameworkAnnotation.class)) {
			ExtentReport.assignAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).authors());
		}
		else {
			ExtentReport.assignAuthors(new String[] {"No Authour"});
		}
	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {

	}



}
