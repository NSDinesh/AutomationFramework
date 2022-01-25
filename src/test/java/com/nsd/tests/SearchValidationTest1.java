package com.nsd.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nsd.driversetup.DriverManager;

public class SearchValidationTest1 extends BaseTest{

	private SearchValidationTest1() {

	}

	@Test
	public void searchMobileCategory() throws InterruptedException {
		DriverManager.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles",Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().
				findElement(By.xpath("//*[contains(@class,'s-desktop-toolbar')]//*[contains(@class,'a-section')]/span[last()]"))));
		Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//*[contains(@class,'s-desktop-toolbar')]//*[contains(@class,'a-section')]/span[last()]")).
				getText().contains("Mobile"));
		Assert.assertTrue(DriverManager.getDriver().getTitle().contains("Mobiles"));
	}

}
