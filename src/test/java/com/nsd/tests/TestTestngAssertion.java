package com.nsd.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTestngAssertion {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println(Thread.currentThread().getId()+"---beforeSuite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println(Thread.currentThread().getId()+"---afterSuite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println(Thread.currentThread().getId()+"---beforeTest");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println(Thread.currentThread().getId()+"---afterTest");
	}
	
	
	@Test
	public void a() {
		/*
		 * Assert.assertTrue(true,"true a"); Assert.assertTrue(false,"false a");
		 * Assert.fail();
		 */
		System.out.println(Thread.currentThread().getId()+"---testa");
	}
	
	@Test
	public void b() {
		/*
		 * Assert.assertTrue(true,"true b"); Assert.assertTrue(false,"false b");
		 */
		System.out.println(Thread.currentThread().getId()+"---testb");
	}
	
	@Test
	public void c() {
		/*
		 * Assert.assertTrue(true,"true c"); Assert.assertTrue(false,"false c");
		 */
		System.out.println(Thread.currentThread().getId()+"---testc");
	}

}
