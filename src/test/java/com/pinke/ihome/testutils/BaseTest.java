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
		//driver = WebDriverUtils.getDriver("Chrome",this.getClass()); // û����propertiesʵ�ֵķ�ʽ����û�з�װ
		//driver = WebDriverUtils.getDriver(ConfigReader.getConfig("browser"),this.getClass()); //������properites��װ�ˣ���resource�����config.properties���ֵ
		driver = WebDriverUtils.getDriver(ConfigReader.getConfig(ConfigReader.BROWER),this.getClass()); //������֤browser����д��
		String wt = ConfigReader.getConfig(ConfigReader.WAITTIME);
		//driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(wt),TimeUnit.SECONDS); //ʵ���˶�Properties�ķ�ʽ
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
