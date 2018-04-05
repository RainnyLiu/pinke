package com.pinke.test.demo;
import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo2 {	
	/*@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest...");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest...");
	}*/
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeTestNGDemo2-Class...");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterTestNGDemo2-Class...");
	}
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("beforeMethod...");
	}
	
	@AfterMethod
	public void afterMethod1() {
		System.out.println("afterMethod...");
	}
	
	@Test
	public void test1() {
		System.out.println("test1...");
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}

	@Test
	public void test2() {
		System.out.println("test2...");
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}
}
