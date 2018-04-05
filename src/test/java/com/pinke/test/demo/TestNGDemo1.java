package com.pinke.test.demo;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TestNGDemo1 {
	@Test(description="�򵥵Ĳ���")
	public void test1() {
		//Assert.assertEquals(10, 10); //import org.testng.Assert;
		assertEquals(10, 11); //import static org.testng.Assert.*;
	}
	
	@Test(dependsOnMethods="test1", alwaysRun=true)
	public void test2() {
		assertEquals(10,10);
	}
	
	@Test(enabled=false) //�൱��ע�͵����test
	public void test3() {
		//Assert.assertEquals(10, 10); //import org.testng.Assert;
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}
	
	@Test(invocationCount=4) //��������4�Σ�һ��һ������
	public void test4() {
		//Assert.assertEquals(10, 10); //import org.testng.Assert;
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}
	
	@Test(invocationCount=4,threadPoolSize=4) //ͬʱ��������4�Σ������̳߳صĴ�Сͬʱ����
	public void test5() {
		//Assert.assertEquals(10, 10); //import org.testng.Assert;
		assertEquals(10, 10); //import static org.testng.Assert.*;
	}

	@Test
	public void test6() {
		assertEquals(10,11);
	}
}
