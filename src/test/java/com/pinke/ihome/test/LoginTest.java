package com.pinke.ihome.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pinke.ihome.pages.IndexPage;
import com.pinke.ihome.pages.LoginPage;
import com.pinke.ihome.testutils.BaseTest;
import com.pinke.webdriver.utils.WebDriverUtils;


public class LoginTest extends BaseTest {
		
	@Test
	public void loginTest() {
		driver.get("http://ihome6.com/Index-index.html");
		IndexPage indexpage = new IndexPage(driver);
		indexpage.goLogin();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.doLogin("xief", "123456");
	}

}
