package com.nsd.tests.amazonTestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsd.assertions.ReportLogger;
import com.nsd.pages.ProductPage;
import com.nsd.pages.components.ApplicationHeader;
import com.nsd.tests.BaseTest;

public class SearchProduct extends BaseTest{
	
	private SearchProduct() {
		
	}

	@Test
	public void searchAndVerifyReasult() {
		ApplicationHeader applicationHeader = new ApplicationHeader();
		ProductPage prdSearchResult = applicationHeader.searchItem("Harry potter");
//		Assert.assertTrue(prdSearchResult.getSearchResultTitle().contains("Harry potter"),
//				"Header should contain the product searched");
		ReportLogger.verifyTrue(prdSearchResult.getSearchResultTitle().contains("Harry potter"),
				"Header should contain the product searched", false);
	}
	
	@Test
	public void searchAndVerifyReasult1() {
		ApplicationHeader applicationHeader = new ApplicationHeader();
		ProductPage prdSearchResult = applicationHeader.searchItem("Game of thrones");
//		Assert.assertTrue(prdSearchResult.getSearchResultTitle().contains("Game of thrones"),
//				"Header should contain the product searched");
		ReportLogger.verifyTrue(prdSearchResult.getSearchResultTitle().contains("Game of thrones"),
				"Header should contain the product searched", false);
	}
	
	@DataProvider
	public String[] data() {
		return new String[]{"Harry potter","Game of thrones"};
	}

}
