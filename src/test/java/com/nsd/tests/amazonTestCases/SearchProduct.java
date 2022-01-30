package com.nsd.tests.amazonTestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsd.annotation.FrameworkAnnotation;
import com.nsd.assertions.ReportLogger;
import com.nsd.pages.ProductPage;
import com.nsd.pages.components.ApplicationHeader;
import com.nsd.tests.BaseTest;

public class SearchProduct extends BaseTest{
	
	private SearchProduct() {
		
	}

//	@FrameworkAnnotation(authors = {"Dinesh"})
	@Test
	public void searchAndVerifyReasult() {
		ApplicationHeader applicationHeader = new ApplicationHeader();
		ProductPage prdSearchResult = applicationHeader.searchItem("Harry potter");
		ReportLogger.verifyTrue(prdSearchResult.getSearchResultTitle().contains("Ha potter"),
				"Header should contain the product searched", false);
		ReportLogger.verifyTrue(prdSearchResult.getSearchResultTitle().contains("Harry potter"),
				"Header should contain the product searched", false);
	}
	
	@FrameworkAnnotation(authors = {"Dinesh","Colleague1"})
	@Test
	public void searchAndVerifyReasult1() {
		ApplicationHeader applicationHeader = new ApplicationHeader();
		ProductPage prdSearchResult = applicationHeader.searchItem("Game of thrones");
		ReportLogger.verifyTrue(prdSearchResult.getSearchResultTitle().contains("Ha potter"),
				"Header should contain the product searched", false);
		ReportLogger.verifyTrue(prdSearchResult.getSearchResultTitle().contains("Game of thrones"),
				"Header should contain the product searched", false);
	}
	
	@DataProvider
	public String[] data() {
		return new String[]{"Harry potter","Game of thrones"};
	}

}
