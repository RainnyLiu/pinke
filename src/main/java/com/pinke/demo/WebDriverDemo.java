package com.pinke.demo;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverDemo {
	public static void main(String[] args) {
		ChromeDriverService service = new ChromeDriverService.Builder()  //独立启动chrome service,即只启动一次
				.usingDriverExecutable(new File("drivers/chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		
		try {
			service.start(); //启动服务
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		URL url = service.getUrl();
		
		WebDriverDemo w = new WebDriverDemo();
		w.openBaidu(url);
		w.openApache(url);
		
		service.stop(); //关闭服务
		
		
	}
	
	public void openBaidu(URL url) {
		//System.setProperty("webdriver.chrome.driver",  "drivers/chromedriver.exe");
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome()); // Driver 通过打开的service，打开两次，效率提高
		driver.get("http://www.baidu.com");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
	}
	
	public void openApache(URL url) {
		//System.setProperty("webdriver.chrome.driver",  "drivers/chromedriver.exe");
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://www.apache.org");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
}
