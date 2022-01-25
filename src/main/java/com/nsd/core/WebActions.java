package com.nsd.core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsd.driversetup.DriverManager;

public class WebActions {
	
	private WebDriver getDriver() {
		return DriverManager.getDriver();
	}
	
	protected WebElement findElement(By locator) {
		return DriverManager.getDriver().findElement(locator);
	}
	
	protected void clickElement(By locator,String elementName) {
		try {
			findElement(locator).click();
		}
		catch(Exception e) {
			throw new RuntimeException("Unable to click the element -"+elementName+"\n Got Exception - "+e.getMessage());
		}
	}
	
	protected void enterText(By locator, String text, String elementName) {
		try {
			findElement(locator).sendKeys(text);
		}
		catch(Exception e) {
			throw new RuntimeException("Unable to enter text in the element -"+elementName+"\n Got Exception - "+e.getMessage());
		}
	}
	
	protected String getText(By locator) {
		try {
			return findElement(locator).getText();
		}
		catch(Exception e) {
			return "";
		}
	}
	
	protected void clearText(By locator) {
		try {
			findElement(locator).clear();
		}
		catch(Exception e) {
			
		}
	}
	
	protected String getAttribute(By locator,String attribute) {
		try {
			return findElement(locator).getAttribute(attribute);
		}
		catch(Exception e) {
			return "";
		}
	}
	
	protected boolean verifyElementDisplayed(By locator) {
		try {
			return findElement(locator).isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	protected boolean waitForElement(By locator, int wait) {
		try {
			new WebDriverWait(getDriver(),Duration.ofSeconds(wait)).until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
