package com.pinke.test.demo;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TestNGDemo1 {
	@Test(description="简单的测试")
	public void test1() {
		//Assert.assertEquals(10, 10); //import org.testng.Assert;
		assertEquals(10, 11); //import static org.testng.Assert.*;
	}
	
	@Test(dependsOnMethods="test1", alwaysRun=true)
	public void test2() {
		assertEquals(10,10);
	}
	
	@Test(enabled=false) //相当于注释掉这个test
	public void test3() {
		//Assert.assertEquals(10, 10); //import org.testng.Assert;
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}
	
	@Test(invocationCount=4) //串行运行4次，一个一个运行
	public void test4() {
		//Assert.assertEquals(10, 10); //import org.testng.Assert;
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}
	
	@Test(invocationCount=4,threadPoolSize=4) //同时并非运行4次，根据线程池的大小同时运行
	public void test5() {
		//Assert.assertEquals(10, 10); //import org.testng.Assert;
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}

	@Test
	public void test6() {
		assertEquals(10,11);
	}
}
