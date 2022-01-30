package com.nsd.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.nsd.constants.FrameworkConstants;
import com.nsd.driversetup.DriverManager;
import com.nsd.driversetup.DriverSetup;
import com.nsd.environmentData.EnvironmentData;
import com.nsd.environmentData.EnvironmentDataManager;
import com.nsd.reporting.ExtentReport;
import com.nsd.utils.PropertiesUtils;

@Listeners(com.nsd.listeners.Listeners.class)
public class BaseTest {
	
	protected BaseTest() {
		
	}
	
	@Parameters({"report"})
	@BeforeTest()
	public void reportSetup(@Optional("") String report) {
		ExtentReport.initReports(report+"extentReport.html");	
	}
	
	@AfterTest()
	public void flushReport() {
		ExtentReport.flushReports();
	}
	
	@Parameters({"browser"})
	@BeforeMethod()
	public void setup(@Optional("") String browser) {
		if(!browser.isBlank()) {
			setEnvironmentDataFromTestNgFile(browser);
		}
		DriverSetup.setup();	
		DriverManager.getDriver().get(PropertiesUtils.getPropValue(FrameworkConstants.CONFIG_FILE_PATH, "url"));
		DriverManager.getDriver().manage().window().maximize();
	}
	
	@AfterMethod()
	public void tearDown() {
		DriverManager.getDriver().quit();
		DriverManager.unload();
	}
	
	private void setEnvironmentDataFromTestNgFile(String browser) {
		EnvironmentDataManager.put(EnvironmentData.BROWSER, browser);
	}
	
}
