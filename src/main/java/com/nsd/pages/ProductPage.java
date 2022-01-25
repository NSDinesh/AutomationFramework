package com.nsd.pages;

import org.openqa.selenium.By;

import com.nsd.core.WebActions;

public class ProductPage extends WebActions{
	
	By headerText = By.xpath("//*[@id='search']//h1");
	
	public String getSearchResultTitle() {
		waitForElement(headerText, 10);
		return getText(headerText);
	}

}
