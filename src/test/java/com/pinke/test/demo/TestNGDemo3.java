package com.pinke.test.demo;
import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo3 {	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeTestNGDemo3-Class...");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterTestNGDemo3-Class...");
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
	public void test3() {
		System.out.println("test3...");
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}

	@Test
	public void test4() {
		System.out.println("test4...");
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}
}
