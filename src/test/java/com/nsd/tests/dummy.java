package com.nsd.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nsd.constants.FrameworkConstants;
import com.nsd.driversetup.DriverManager;
import com.nsd.driversetup.enums.DriverType;
import com.nsd.utils.ExcelUtils;
import com.nsd.utils.FileUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class dummy {

	@Test
	public void file() {
		//set base url
		RestAssured.baseURI = "https://gorest.co.in/public/v1";
		//define http request
		RequestSpecification httpRequest= RestAssured.given();
		//make/execute the rquest
		Response response = httpRequest.request(Method.GET, "users/42");
	
		//get entire response body as string
		String responseAsString = response.getBody().asString();
		System.out.println(responseAsString);
	
		//get statis code of response
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		//get entire headers of response
		Headers headers = response.getHeaders();
		System.out.println(headers);
		
		//get value of particular response
		String contentType = response.getHeader("Content-Type");
		System.out.println(contentType);
		
		JsonPath jsonPath = response.jsonPath();
		String id = jsonPath.getString("data.id");
		System.out.println(id);

	}
	
	@Test
	public void enumTesting() {
//		DriverSetup driverSetup = DriverSetup.ANDROID;
//		System.out.println(driverSetup.getDriverType());
//		String d ="Chrome";
//		System.out.println("Value of "+DriverSetup.valueOf(d.toUpperCase()));
//		System.out.println("Value of "+DriverSetup.valueOf(d.toUpperCase()).getDriverType());
		
		DriverType.ANDROID.setDriverType();
		System.out.println(DriverManager.getDriver() instanceof AppiumDriver);
		System.out.println(DriverManager.getDriver() instanceof AndroidDriver);
		System.out.println(DriverManager.getDriver() instanceof WebDriver);
		System.out.println(DriverManager.getDriver() instanceof IOSDriver);
		System.out.println(DriverManager.getDriver() instanceof ChromeDriver);
		
		System.out.println(".................");
		
		DriverType.CHROME.setDriverType();
		System.out.println(DriverManager.getDriver() instanceof WebDriver);
		System.out.println(DriverManager.getDriver() instanceof ChromeDriver);
		System.out.println(DriverManager.getDriver() instanceof FirefoxDriver);
		System.out.println(DriverManager.getDriver() instanceof AppiumDriver);
		
	}
	
	@Test
	public void readExcel() {
		System.out.println(ExcelUtils.getValuesFromAllRow(FrameworkConstants.EXCEL_DATA_FILE_PATH, "sheet1"));
	}
	
	@Test
	public void extentReportTest() {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter("extentReport.html");
		extentReports.attachReporter(reporter);
		
		ExtentTest extentTest = extentReports.createTest("firstTest", "This test is first created");
		extentTest.assignDevice("samsung");
		extentTest.log(Status.PASS, "passed scenario 1");
		extentTest.log(Status.FAIL, "passed scenario 2");
		extentTest.log(Status.PASS, "passed scenario 3");
		extentTest.log(Status.INFO, "info scenario 4");
		extentTest= extentTest.createNode("first Node").log(Status.PASS, "passed node 1");
		extentTest.assignDevice("oneplus");
		extentTest.log(Status.FAIL, "passed node 2");
		extentTest.log(Status.PASS, "passed node 3");
		extentTest.log(Status.INFO, "info node 4");
		extentTest = extentReports.createTest("secondTest", "This test is second created");
		extentTest.assignDevice("samsung");
		extentTest = extentReports.createTest("Third Test", "This test is third created");
		extentTest.log(Status.PASS, "Test3 passed");
		
		extentReports.flush();
	}
	

	

}
