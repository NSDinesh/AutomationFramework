package com.nsd.assertions;

import org.testng.Assert;

import com.nsd.reporting.ExtentLogger;

public class ReportLogger {
	
	
	public static void verifyTrue(boolean condition, String message, boolean assertFail) {
		try {
			Assert.assertTrue(condition);
			ExtentLogger.pass(message);
		}
		catch(AssertionError error) {
			fail(message,assertFail);
		}
	}
	
	
	private static void fail(String message, boolean assertFail) {
		ExtentLogger.fail(message);
		if(assertFail)
			Assert.fail();
	}

}
