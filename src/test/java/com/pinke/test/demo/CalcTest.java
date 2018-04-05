package com.pinke.test.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.pinke.demo.Calc;
import com.pinke.testdata.TestDataFactory;

public class CalcTest {
	private Calc calc;
	@BeforeClass
	public void init() {
		calc = new Calc();
	}
	/*@DataProvider(name="calc_data")
	public Object[][] calcTestData(){
		Object[][] objs = new Object[][] {
			{10,20,30},
			{30,10,20},
			{30,30,60}
		};
		return objs;
	}
	*/
	
	//@Test(dataProvider="calc_data")
	@Test(dataProviderClass = TestDataFactory.class, dataProvider = "calc_mysql_data")
	public void testCompute1(int x, int y, int expected) {	
		int actual = calc.compute(x, y);
		assertEquals(actual,expected);
		
	}
	
	/*@Test
	public void testCompute1() {
		int x = 10,y = 20;
		int expected =30;
		//Calc calc = new Calc(); //有了前面beforeClass的方法，这里就可以省略了
		int actual = calc.compute(x, y);
		assertEquals(actual,expected);
		
	}
	
	@Test
	public void testCompute2() {
		int x = 30,y = 10;
		int expected = 20;
		//Calc calc = new Calc();
		int actual = calc.compute(x, y);
		assertEquals(actual,expected);
		
	}
	
	@Test
	public void testCompute3() {
		int x = 30, y = 30;
		int expected = 60;
		//Calc calc = new Calc();
		int actual = calc.compute(x, y);
		assertEquals(actual,expected);
		
	}*/

}
