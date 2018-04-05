package com.pinke.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.GeckoDriverService.Builder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class WebDriverUtils {
	private static DriverService service;
	static { //第一个调用的会使用这个，之后就会，因为这是static
		service = new ChromeDriverService.Builder()  //独立启动chrome service,即只启动一次
				.usingDriverExecutable(new File("drivers/chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		
		try {
			service.start(); //启动服务
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static WebDriver geChrometDriver() { //第二个调用的，就启用这个
		URL url = service.getUrl(); 
		
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome()); // Driver 通过打开的service，打开两次，效率提高
		return driver;
	}
	
	public static void stopService() {
		service.stop(); //关闭服务
	}
	
/*	private static Builder geckservice;
	static { //第一个调用的会使用这个，之后就会，因为这是static
		geckservice = new GeckoDriverService.Builder();  //独立启动chrome service,即只启动一次
				.usingDriverExecutable(new File("drivers/geckodriver.exe"))
				.usingAnyFreePort()
				.build();
		
		try {
			geckservice.start(); //启动服务
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static WebDriver geFirxtDriver() { //第二个调用的，就启用这个
		URL url = geckservice.getUrl(); 
		
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.firefox()); // Driver 通过打开的service，打开两次，效率提高
		return driver;
	}
	
	
	private static org.openqa.selenium.remote.service.DriverService.Builder<GeckoDriverService, Builder> usingDriverExecutable(
			File file) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void stopGeckoService() {
		geckservice.stop(); //关闭服务
	}*/

}
