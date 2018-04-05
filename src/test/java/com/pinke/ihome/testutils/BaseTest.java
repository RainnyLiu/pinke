package com.pinke.ihome.testutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pinke.webdriver.utils.ConfigReader;
import com.pinke.webdriver.utils.WebDriverUtils;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod
	public void openBrowser() {
		//driver = WebDriverUtils.getDriver("Chrome",this.getClass()); // 没有用properties实现的方式，即没有封装
		//driver = WebDriverUtils.getDriver(ConfigReader.getConfig("browser"),this.getClass()); //重新用properites封装了，从resource里读出config.properties里的值
		driver = WebDriverUtils.getDriver(ConfigReader.getConfig(ConfigReader.BROWER),this.getClass()); //这样保证browser不被写错！
		String wt = ConfigReader.getConfig(ConfigReader.WAITTIME);
		//driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(wt),TimeUnit.SECONDS); //实现了读Properties的方式
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
