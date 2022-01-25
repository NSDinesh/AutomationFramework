package com.nsd.tests;

import java.nio.charset.Charset;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nsd.assertions.ReportLogger;
import com.nsd.constants.FrameworkConstants;
import com.nsd.driversetup.DriverManager;
import com.nsd.driversetup.DriverSetup;
import com.nsd.utils.PropertiesUtils;

public final class SearchValidationTest extends BaseTest{
	
	private SearchValidationTest() {
		
	}

	@Test
	public void searchMobileCategory() throws InterruptedException {
		DriverManager.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles",Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().
				findElement(By.xpath("//*[contains(@class,'s-desktop-toolbar')]//*[contains(@class,'a-section')]/span[last()]"))));
//		Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//*[contains(@class,'s-desktop-toolbar')]//*[contains(@class,'a-section')]/span[last()]")).
//				getText().contains("Mobile"));
//		Assert.assertTrue(DriverManager.getDriver().getTitle().contains("Mobiles"));
		
		ReportLogger.verifyTrue(DriverManager.getDriver().findElement(By.xpath("//*[contains(@class,'s-desktop-toolbar')]//*[contains(@class,'a-section')]/span[last()]")).
				getText().contains("Mobile"), "Searched text is present", false);
		ReportLogger.verifyTrue(DriverManager.getDriver().getTitle().contains("Mobilea"),"Searvhed text should be present in title",true);
		ReportLogger.verifyTrue(DriverManager.getDriver().getTitle().contains("Mobilea"),"Searvhed text should be present in title",false);
	}
	
	@Test
	public void searchxLaptopCategory() throws InterruptedException {	
		DriverManager.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop",Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().
				findElement(By.xpath("//*[contains(@class,'s-desktop-toolbar')]//*[contains(@class,'a-section')]/span[last()]"))));
//		Assert.assertTrue(DriverManager.getDriver().
//				findElement(By.xpath("//*[contains(@class,'s-desktop-toolbar')]//*[contains(@class,'a-section')]/span[last()]")).
//				getText().contains("Laptop"));
//		Assert.assertTrue(DriverManager.getDriver().getTitle().contains("Laptop"));
//		((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		
		ReportLogger.verifyTrue(DriverManager.getDriver().findElement(By.xpath("//*[contains(@class,'s-desktop-toolbar')]//*[contains(@class,'a-section')]/span[last()]")).
				getText().contains("Laptop"), "Searched text is present", false);
		ReportLogger.verifyTrue(DriverManager.getDriver().getTitle().contains("Laptop"),"Searvhed text should be present in title",true);
		ReportLogger.verifyTrue(DriverManager.getDriver().getTitle().contains("Laptop"),"Searvhed text should be present in title",false);

	}	

}
