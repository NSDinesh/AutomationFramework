package com.nsd.pages.components;

import org.openqa.selenium.By;

import com.nsd.core.WebActions;
import com.nsd.pages.ProductPage;

public class ApplicationHeader extends WebActions{
	
	By searchTextBox = By.id("twotabsearchtextbox");
	By searchTextBoxSubmitButton = By.id("nav-search-submit-button");
	
	public ProductPage searchItem(String itemToSearch) {
		enterText(searchTextBox, itemToSearch, "Search Textbox");
		clickElement(searchTextBoxSubmitButton, "Search Textbox Submit Button");
		return new ProductPage();
	}
	
}
